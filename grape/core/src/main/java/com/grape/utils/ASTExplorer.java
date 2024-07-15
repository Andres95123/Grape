package com.grape.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import com.grape.utils.AST.BlockNode;
import com.grape.utils.AST.Node;
import com.grape.utils.AST.ProgramNode;
import com.grape.utils.AST.Comandos.AssignNode;
import com.grape.utils.AST.Comandos.Comandos;
import com.grape.utils.AST.Comandos.ForNode;
import com.grape.utils.AST.Comandos.IfNode;
import com.grape.utils.AST.Comandos.IncrementNode;
import com.grape.utils.AST.Definiciones.ExpresionNode;
import com.grape.utils.AST.Definiciones.FunctionNode;
import com.grape.utils.AST.Definiciones.ValueNode;
import com.grape.utils.AST.Definiciones.VariableNode;

// Clase que se encarga de recorrer el AST de un Programa, empezando por el ProgramNode

public class ASTExplorer {

    private static Stack<IntermedianCode> intermedianCode = new Stack<>();
    public static Stack<VariableNode> variables = new Stack<>();

    public static Stack<IntermedianCode> explore(ProgramNode raiz) {

        for (Node node : raiz.getNodes()) {
            explore(node);
        }

        // Print variables

        for (VariableNode variable : variables) {
            System.out.println(variable);
        }

        // Separator
        System.out.println("----------");

        // Print intermedian code
        for (IntermedianCode ic : intermedianCode) {
            System.out.println(ic);
        }

        return intermedianCode;

    }

    private static String explore(Node node) {

        // Exploraciones estructurales

        if (node instanceof BlockNode) {

            // Es un bloque, recorremos sus nodos y seguimos explorando
            for (Node n : ((BlockNode) node).getNodes()) {
                explore(n);
            }

            // No devolvemos nada
            return null;
        }

        if (node instanceof ExpresionNode) {
            // Es una expresión binaria, exploramos los dos hijos y generamos el código
            // intermedio realizando la operación
            ExpresionNode expresionNode = (ExpresionNode) node;

            // Hijo derecho e izquierdo
            Node left = expresionNode.getLeft();
            Node right = expresionNode.getRight();

            // Obtenemos las variables de los hijos
            String varLeft = explore(left);
            String varRight = explore(right);

            // Obtenemos el comando
            Comandos expresion = expresionNode.getComando();

            // Sino, Añadimos el código intermedio
            String tmpVar = makeNewTmpVar();

            intermedianCode.add(new IntermedianCode(expresion, varLeft, varRight, tmpVar));

            // Devolvemos la variable temporal
            return tmpVar;

        }

        // Exploraciones no estructurales

        // Comandos

        if (node instanceof AssignNode) {
            // Es una asignación, exploramos el hijo derecho y generamos el código
            // intermedio
            AssignNode assign = (AssignNode) node;

            // Añadimos el código intermedio
            String varTmp = explore(assign.getRight());

            VariableNode variable = (VariableNode) assign.getLeft();

            intermedianCode.add(new IntermedianCode(Comandos.ASSIGN, varTmp, null, variable.getName()));

            // Devolvemos el nombre de la variable
            return variable.getName();
        }

        if (node instanceof IncrementNode) {
            // Es un nodo de post incremento/decremento
            IncrementNode increment = (IncrementNode) node;

            // Obtenemos la variable
            VariableNode variable = increment.getVariable();

            // Obtenemos la variable temporal
            String varTmp = makeNewTmpVar();

            // Guardamos el valor original en la var tmp
            intermedianCode.add(new IntermedianCode(Comandos.ASSIGN, variable.getName(), null, varTmp));

            // Incrementamos en 1 la variable original
            intermedianCode.add(new IntermedianCode(increment.getOp(), variable.getName(), "1", variable.getName()));

            // Devolvemos la varTmp
            return varTmp;

        }

        if (node instanceof IfNode) {
            // Es un nodo de If
            IfNode ifNode = (IfNode) node;

            // Obtenemos la condición
            String varTmp = explore(ifNode.getCondition());

            // Obtenemos las etiquetas
            String etiquetaElse = makeNewEtiqueta();
            String etiquetaFin = makeNewEtiqueta();

            // Si varTmp es false, saltamos a la etiqueta, 0 es false y -1 true
            intermedianCode.add(new IntermedianCode(Comandos.IF_EQ, varTmp, "0", etiquetaElse));

            // Exploramos el cuerpo del if
            explore(ifNode.getIfBody());

            // Saltamos a la etiqueta de fin
            intermedianCode.add(new IntermedianCode(Comandos.GOTO, null, null, etiquetaFin));

            // Añadimos la etiqueta else
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, etiquetaElse));

            // Exploramos el cuerpo del else si existe
            if (ifNode.getElseBody() != null) {
                explore(ifNode.getElseBody());
            }

            // Añadimos la etiqueta de fin
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, etiquetaFin));

            return null;

        }

        if (node instanceof ForNode) {

            ForNode forNode = (ForNode) node;

            // Obtenemos las etiquetas
            String etiquetaInicio = makeNewEtiqueta();
            String etiquetaFin = makeNewEtiqueta();

            // Realizamos la asignación
            explore(forNode.getInit());

            // Añadimos la etiqueta de inicio
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, etiquetaInicio));

            // Obtenemos la condición
            String varTmp = explore(forNode.getCondition());

            // Si varTmp es false, saltamos a la etiqueta, 0 es false y -1 true
            intermedianCode.add(new IntermedianCode(Comandos.IF_EQ, varTmp, "0", etiquetaFin));

            // Exploramos el cuerpo del for
            explore(forNode.getBody());

            // Realizamos la asignación
            explore(forNode.getIncrement());

            // Saltamos a la etiqueta de inicio
            intermedianCode.add(new IntermedianCode(Comandos.GOTO, null, null, etiquetaInicio));

            // Añadimos la etiqueta de fin
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, etiquetaFin));

            return null;

        }

        if (node instanceof FunctionNode) {

            FunctionNode function = (FunctionNode) node;

            // Creamos la etiqueta de la función
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, function.getName()));

            // Exploramos el bloque de la función
            explore(function.getBlock());

            // Añadimos la etiqueta de fin de la función
            intermedianCode.add(new IntermedianCode(Comandos.ETIQUETA, null, null, "END_" + function.getName()));

            return null;

        }

        // Estructuras de control

        if (node instanceof VariableNode) {

            VariableNode variable = (VariableNode) node;

            // Si ya se ha instanciado, devolvemos el nombre
            if (variable.isInstanced()) {
                return variable.getName();
            }

            // Es una variable con una expresión

            if (variable.getValue() instanceof ExpresionNode) {

                // Obtenemos la variable de la expresión
                String varTmp = explore(variable.getValue());

                // Añadimos el código intermedio
                intermedianCode.add(new IntermedianCode(Comandos.ASSIGN, varTmp, null, variable.getName()));
            }

            // La añadimos a la lista de variables y devolvemos

            variables.add(variable);

            // Indicamos que ya se ha instanciado la variable
            variable.setInstanced();

            return variable.getName();

        }

        if (node instanceof ValueNode) {

            ValueNode value = (ValueNode) node;

            // Es un valor, devolvemos el valor
            return value.toString();

        }

        throw new UnsupportedOperationException("Unimplemented method 'explore' for node " + node.getClass().getName());

    }

    private static int numEtiqueta = 0;
    public static int numTmpVar = 0;

    private static String makeNewEtiqueta() {
        return "E" + numEtiqueta++;
    }

    private static String makeNewTmpVar() {
        return "T" + numTmpVar++;
    }

}
