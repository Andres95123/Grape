package com.grape.utils;

import java.util.ArrayList;

import com.grape.IntermedianCode.*;
import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.SymbolType;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.Tables.SymbolTable;
import com.grape.utils.AST.Node;
import com.grape.utils.AST.Base.Expresion;
import com.grape.utils.AST.Base.ExpresionNode;
import com.grape.utils.AST.Base.ValueNode;
import com.grape.utils.AST.Base.VarNode;
import com.grape.utils.AST.Comandos.AddressNode;
import com.grape.utils.AST.Comandos.AssignNode;
import com.grape.utils.AST.Comandos.FuncCallNode;
import com.grape.utils.AST.Comandos.IncrementNode;
import com.grape.utils.AST.Comandos.ReturnFuncNode;
import com.grape.utils.AST.Estructuras.BloqueComando;
import com.grape.utils.AST.Estructuras.EstructuraControl;
import com.grape.utils.AST.Estructuras.ForNode;
import com.grape.utils.AST.Estructuras.FuncNode;
import com.grape.utils.AST.Estructuras.IfNode;

import java.util.List;

// Clase que se encarga de recorrer el AST de un Programa, empezando por el ProgramNode

public class ASTExplorer {

    public static SymbolTable symTable = new SymbolTable();

    public static List<IntermedianCode> allCode;

    public static void explore(EstructuraControl[] node) {
        allCode = new ArrayList<>();
        for (EstructuraControl n : node) {
            explore(n, allCode);
        }
    }

    private static String explore(Node node, List<IntermedianCode> intermediateCode) {

        if (node instanceof BloqueComando) {
            BloqueComando block = (BloqueComando) node;
            for (Node n : block.getNodes()) {
                explore(n, intermediateCode);
            }

            return null;
        }

        if (node instanceof VarNode) {
            VarNode var = (VarNode) node;

            // Añadimos a la tabla de simbolos la variable
            symTable.addVariable(var.getSymbol());

            if (!var.isNull()) {
                String valueVar = explore(var.getValue(), intermediateCode);
                intermediateCode
                        .add(new IntermedianCode(Code.ASSIGN, valueVar, null, var.getSymbol().getLocation()));
            }

            return var.getSymbol().getName();
        }

        if (node instanceof AddressNode) {
            AddressNode address = (AddressNode) node;

            String varName = address.getSymbol();

            return symTable.getVariable(varName).getName();
        }

        if (node instanceof ValueNode) {
            ValueNode value = (ValueNode) node;

            // Guardamos el valor en una variable temporal
            GrapeSymbol tmpVar = makeNewTmpVar(value.getTipo());

            intermediateCode.add(new IntermedianCode(Code.ASSIGN, value.getValue(), null,
                    tmpVar.getLocation()));

            return tmpVar.getName();
        }

        if (node instanceof IncrementNode) {
            IncrementNode inc = (IncrementNode) node;

            boolean post = inc.isPost();

            GrapeSymbol symbol = symTable.getVariable(inc.getSymbol());
            GrapeSymbol tmpVar = makeNewTmpVar(symbol.getSubtype());

            // Si post es false, es pre incremento/decremento
            if (!post) {
                // Incrementamos el simbolo original
                intermediateCode.add(
                        new IntermedianCode(Code.valueOf(inc.getOperator().name()), null, null,
                                symbol.getLocation()));

                // Asignamos el valor del simbolo original a la variable temporal
                intermediateCode
                        .add(new IntermedianCode(Code.ASSIGN, symbol.getLocation(), null,
                                tmpVar.getLocation()));

                // Devolvemos la variable temporal
                return tmpVar.getName();
            }

            // Si post es true, es post incremento/decremento

            // Asignamos el valor del simbolo original a la variable temporal
            intermediateCode.add(new IntermedianCode(Code.ASSIGN, symbol.getLocation(),
                    null, tmpVar.getLocation()));

            // Incrementamos el simbolo original
            intermediateCode
                    .add(new IntermedianCode(Code.valueOf(inc.getOperator().name()), null, null,
                            symbol.getLocation()));

            // Devolvemos la variable temporal
            return tmpVar.getName();
        }

        if (node instanceof IfNode) {

            IfNode ifNode = (IfNode) node;

            String condition = explore(ifNode.getCondition(), intermediateCode); // Contiene el resultado de la
                                                                                 // condicion en una var

            String etiqueta_else = makeNewEtiqueta(); // Etiqueta para el salto si la condicion es falsa
            String etiqueta_fin = makeNewEtiqueta(); // Etiqueta para el salto al final del if

            intermediateCode.add(new IntermedianCode(Code.JEQ, condition, "0", etiqueta_else)); // Si la condicion es
                                                                                                // falsa, salta a la
                                                                                                // etiqueta

            for (EstructuraControl n : ifNode.getIfBody()) {
                explore(n, intermediateCode); // Exploramos el cuerpo del if
            }

            intermediateCode.add(new IntermedianCode(Code.JMP, null, null, etiqueta_fin)); // Si la condicion es falsa,
                                                                                           // salta a la etiqueta

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_else)); // Etiqueta para el salto
                                                                                              // si la condicion es
                                                                                              // falsa

            if (ifNode.getElseBody() != null) {
                for (EstructuraControl n : ifNode.getElseBody()) {
                    explore(n, intermediateCode); // Exploramos el cuerpo del else
                }
            }

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_fin)); // Etiqueta para el salto
                                                                                             // al
                                                                                             // final del if

            return null;
        }

        if (node instanceof ForNode) {

            ForNode forNode = (ForNode) node;

            String etiqueta_inicio = makeNewEtiqueta(); // Etiqueta para el inicio del
            // for
            String etiqueta_fin = makeNewEtiqueta(); // Etiqueta para el final del for

            if (forNode.getInit() != null) {
                explore(forNode.getInit(), intermediateCode); // Exploramos la inicializacion del for
            }

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null,
                    etiqueta_inicio)); // Etiqueta para el inicio del for

            if (forNode.getCondition() != null) {
                String condition = explore(forNode.getCondition(), intermediateCode); // Contiene el resultado de la
                                                                                      // condicion en una var

                intermediateCode.add(new IntermedianCode(Code.JEQ, condition, "0",
                        etiqueta_fin)); // Si la condicion es falsa, salta a la etiqueta
            }

            for (EstructuraControl n : forNode.getBody()) {
                explore(n, intermediateCode); // Exploramos el cuerpo del for
            }

            if (forNode.getIncrement() != null) {
                explore(forNode.getIncrement(), intermediateCode); // Exploramos el incremento del for
            }

            intermediateCode.add(new IntermedianCode(Code.JMP, null, null,
                    etiqueta_inicio)); // Salta al inicio del for

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null,
                    etiqueta_fin)); // Etiqueta para el final del for

            return null;
        }

        if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;

            GrapeSymbol var = symTable.getVariable(assign.getVar());

            String value = explore(assign.getValue(), intermediateCode);
            GrapeSymbol valueS = symTable.getVariable(value);

            intermediateCode
                    .add(new IntermedianCode(Code.ASSIGN, valueS.getLocation(), null,
                            var.getLocation()));

            return var.getName();
        }

        if (node instanceof ExpresionNode) {
            ExpresionNode exp = (ExpresionNode) node;

            String left = explore(exp.getLeft(), intermediateCode);
            String right = explore(exp.getRight(), intermediateCode);

            GrapeSymbol leftS = symTable.getVariable(left);
            GrapeSymbol rightS = symTable.getVariable(right);

            if (leftS.getSubtype() != rightS.getSubtype()) {
                throw new RuntimeException("Tipos incompatibles en la expresion");
            }

            GrapeSymbol tmpVar = makeNewTmpVar(leftS.getSubtype());

            intermediateCode.add(
                    new IntermedianCode(Code.valueOf(exp.getOperator().name()), leftS.getLocation(),
                            rightS.getLocation(), tmpVar.getLocation()));

            return tmpVar.getName();
        }

        if (node instanceof FuncNode) {
            FuncNode func = (FuncNode) node;
            List<IntermedianCode> funcCode = new ArrayList<>();

            // Entramos al bloque de la funcion
            symTable.enterBlock();

            // Añadimos la funcion
            symTable.addFunction(func.getFunctionSym());

            // Indicamos que estamos dentro de una funcion
            symTable.enterFunction(func.getFunctionSym());

            // Hacemos un pop de el salto de retorno y lo guardamos en r10 para poder
            // hacer
            // un push al retornar
            funcCode.add(new IntermedianCode(Code.POP, null, null, "r10"));

            // Exploramos los parametros
            for (int i = func.getParameters().length - 1; i >= 0; i--) {
                VarNode n = func.getParameters()[i];

                String var = explore(n, funcCode);
                GrapeSymbol varS = symTable.getVariable(var);

                // Guardamos en var sacado de la pila
                funcCode.add(new IntermedianCode(Code.POP, null, null, varS.getLocation()));
            }

            // Exploramos el cuerpo de la funcion

            for (EstructuraControl n : func.getBody()) {
                explore(n, funcCode);
            }

            FunctionSymbol function = symTable.getFunction(func.getName());
            function.setFuncCode(funcCode);

            // Salir del bloque de la funcion
            symTable.exitBlock();

            return null;
        }

        if (node instanceof FuncCallNode) {
            FuncCallNode funcCall = (FuncCallNode) node;

            FunctionSymbol funcSymbol = symTable.getFunction(funcCall.getFuncSymbol());

            if (funcSymbol.getParameters().length != funcCall.getParameters().length) {
                throw new RuntimeException(
                        "Numero de parametros incorrecto en la llamada a la funcion " + funcCall.getFuncSymbol());
            }

            // Metemos los parametros en la pila
            for (int i = 0; i < funcCall.getParameters().length; i++) {
                Expresion n = funcCall.getParameters()[i];
                String value = explore(n, intermediateCode);
                GrapeSymbol valueS = symTable.getVariable(value);
                UnderlyingSymbolType paramTipe = ((VarNode) funcSymbol.getParameters()[i]).getTipo();

                if (valueS.getSubtype() != paramTipe) {
                    throw new RuntimeException("Tipos incompatibles en la llamada a la funcion");
                }

                intermediateCode.add(new IntermedianCode(Code.PUSH, null, null, valueS.getLocation()));
            }

            // Llamamos a la funcion
            intermediateCode.add(new IntermedianCode(Code.CALL, null, null,
                    funcSymbol.getName()));

            // Creamos una variable temporal para guardar el valor de retorno
            GrapeSymbol tmpVar = makeNewTmpVar(funcSymbol.getReturnType());
            String funcReturnVar = funcSymbol.getReturnSymbol().getLocation();

            // Guardamos
            intermediateCode.add(new IntermedianCode(Code.ASSIGN, funcReturnVar, null,
                    tmpVar.getLocation()));

            return tmpVar.getName();

        }

        if (node instanceof ReturnFuncNode) {
            ReturnFuncNode returnFunc = (ReturnFuncNode) node;

            if (!symTable.hasFunctions()) {
                throw new RuntimeException("Return statement outside of a function");
            }

            String value = explore(returnFunc.getReturnNode(), intermediateCode);

            GrapeSymbol valueS = symTable.getVariable(value);

            // Hacemos un push del valor de retorno
            intermediateCode.add(new IntermedianCode(Code.PUSH, null, null, "r10"));

            intermediateCode.add(new IntermedianCode(Code.RETURN, valueS.getLocation(), null,
                    symTable.popFunction().getReturnSymbol().getLocation()));

            return null;
        }

        throw new RuntimeException("Unknown node type: " + node.getClass().getName());

    }

    private static int numEtiqueta = 0;
    public static int numTmpVar = 0;

    public static String makeNewEtiqueta() {
        return "E" + numEtiqueta++;
    }

    public static GrapeSymbol makeNewTmpVar(UnderlyingSymbolType type) {
        GrapeSymbol tmpVar = new GrapeSymbol("T" + numTmpVar++, SymbolType.ARRAY, type, 1, 0);

        symTable.addVariable(tmpVar);

        return tmpVar;
    }

}
