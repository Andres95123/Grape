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
import com.grape.utils.AST.Definiciones.ExpresionNode;
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

        // Print intermedian code
        for (IntermedianCode ic : intermedianCode) {
            System.out.println(ic);
        }

        return intermedianCode;

    }

    private static String explore(Node node) {

        if (node instanceof ValueNode) {

            ValueNode tmp = (ValueNode) node;
            return tmp.getValue().toString();

        }

        if (node instanceof VariableNode) {

            VariableNode tmp = (VariableNode) node;
            if (tmp.getValue() instanceof ExpresionNode) {
                return explore(tmp.getValue());

            }
            if (!tmp.isInstanced()) {
                variables.push(tmp);
                tmp.setInstanced();
            }
            return tmp.getName();

        }

        if (node instanceof AssignNode) {

            System.out.println("AssignNode");

            AssignNode tmp = (AssignNode) node;
            VariableNode left = (VariableNode) tmp.getLeft();

            // Comprovamos que la variable a la que se le asigna un valor es una variable
            intermedianCode.push(new IntermedianCode(Comandos.ASSIGN, explore(tmp.getRight()), null, left.getName()));

            return left.getName();

        }

        if (node instanceof IfNode) {

            // Comprovamos que la condicion del if es una expresion
            if (!(((IfNode) node).getCondition() instanceof ExpresionNode)) {
                throw new UnsupportedOperationException("La condicion del if no es una expresion valida");
            }

            IfNode tmp = (IfNode) node;
            String etiqueta = makeNewEtiqueta();

            Comandos comando = Comandos.valueOf("IF_" + tmp.getCondition().getOp().name());

            // Si no se cumple el condicional, se salta a la siguiente etiqueta
            intermedianCode.push(new IntermedianCode(comando, explore(tmp.getCondition().getLeft()),
                    explore(tmp.getCondition().getRight()), etiqueta));

            // Creamos la etiqueta
            intermedianCode.push(new IntermedianCode(Comandos.ETIQUETA, null, null, etiqueta));

            return "";
        }

        if (node instanceof ForNode) {

            // Comprovamos que la condicion del for es una expresion
            if (!(((ForNode) node).getCondition() instanceof ExpresionNode)) {
                throw new UnsupportedOperationException("La condicion del for no es una expresion valida");
            }

            // ForNode tmp = (ForNode) node;
            // String etiquetaBucle = makeNewEtiqueta();
            // String etiquetaFin = makeNewEtiqueta();

            // // Inicializamos la variable del bucle
            // intermedianCode.push(new IntermedianCode(Comandos.ASSIGN,
            // explore(tmp.getInit()), null,
            // ((VariableNode) tmp.getInit()).getName()));

            // // Creamos la etiqueta de inicio del bucle
            // intermedianCode.push(new IntermedianCode(Comandos.ETIQUETA, null, null,
            // etiquetaBucle));

            // // Comprobamos la condicion del bucle
            // Comandos comando = Comandos.valueOf("IF_" + ((ExpresionNode)
            // tmp.getCondition()).getOp().name());
            // intermedianCode.push(new IntermedianCode(comando, explore(((ExpresionNode)
            // tmp.getCondition()).getLeft()),
            // explore(((ExpresionNode) tmp.getCondition()).getRight()), etiquetaFin));

            // // Ejecutamos el cuerpo del bucle
            // explore(tmp.getBody());

            // // Incrementamos la variable del bucle
            // intermedianCode.push(new IntermedianCode(Comandos.ASSIGN,
            // explore(tmp.getIncrement()), null,
            // ((VariableNode) tmp.getIncrement()).getName()));

            // // Saltamos al inicio del bucle
            // intermedianCode.push(new IntermedianCode(Comandos.GOTO, null, null,
            // etiquetaBucle));

            // // Creamos la etiqueta de fin del bucle
            // intermedianCode.push(new IntermedianCode(Comandos.ETIQUETA, null, null,
            // etiquetaFin));

            return "";

        }

        if (node instanceof ExpresionNode) {

            ExpresionNode tmp = (ExpresionNode) node;
            String tmpVar = makeNewTmpVar();
            intermedianCode.push(new IntermedianCode(Comandos.valueOf(tmp.getOp().name()), explore(tmp.getLeft()),
                    explore(tmp.getRight()), tmpVar));

            return tmpVar;

        }

        if (node instanceof BlockNode) {

            for (Node n : ((BlockNode) node).getNodes()) {
                explore(n);
            }

            return "";

        }

        throw new UnsupportedOperationException("Unimplemented method 'explore'");

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
