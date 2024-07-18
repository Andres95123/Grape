package com.grape.utils;

import java.util.ArrayList;

import com.grape.IntermedianCode.*;
import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.SymbolType;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.Tables.SymbolTable;
import com.grape.utils.AST.AddressNode;
import com.grape.utils.AST.AssignNode;
import com.grape.utils.AST.BlockNode;
import com.grape.utils.AST.ExpresionNode;
import com.grape.utils.AST.ForNode;
import com.grape.utils.AST.FuncCallNode;
import com.grape.utils.AST.FuncNode;
import com.grape.utils.AST.IfNode;
import com.grape.utils.AST.IncrementNode;
import com.grape.utils.AST.Node;
import com.grape.utils.AST.ReturnFuncNode;
import com.grape.utils.AST.ReturnNode;
import com.grape.utils.AST.ValueNode;
import com.grape.utils.AST.VarNode;

import java.util.List;

// Clase que se encarga de recorrer el AST de un Programa, empezando por el ProgramNode

public class ASTExplorer {

    public static List<IntermedianCode> allCode;
    private static SymbolTable symTable;

    public static void explore(BlockNode node, SymbolTable table) {
        allCode = new ArrayList<>();
        symTable = table;
        explore((Node) node, allCode);
    }

    private static String explore(Node node, List<IntermedianCode> intermediateCode) {

        if (node instanceof BlockNode) {
            BlockNode block = (BlockNode) node;
            for (Node n : block.getNodes()) {
                explore(n, intermediateCode);
            }

            return null;
        }

        if (node instanceof VarNode) {
            VarNode var = (VarNode) node;

            if (!var.isNull()) {
                String valueVar = explore(var.getValue(), intermediateCode);
                intermediateCode
                        .add(new IntermedianCode(Code.ASSIGN, valueVar, null, var.getSymbol().getLocation()));
            }

            return var.getSymbol().getLocation();
        }

        if (node instanceof AddressNode) {
            AddressNode address = (AddressNode) node;

            return address.getSymbol().getLocation();
        }

        if (node instanceof ValueNode) {
            ValueNode value = (ValueNode) node;

            return value.getValue().toString();
        }

        if (node instanceof IncrementNode) {
            IncrementNode inc = (IncrementNode) node;

            boolean post = inc.isPost();

            GrapeSymbol symbol = inc.getSymbol();
            GrapeSymbol tmpVar = makeNewTmpVar(inc.getTipo());

            // Si post es false, es pre incremento/decremento
            if (!post) {

                // Incrementamos el simbolo original
                intermediateCode.add(
                        new IntermedianCode(Code.valueOf(inc.getOperator().name()), null, null, symbol.getLocation()));

                // Asignamos el valor del simbolo original a la variable temporal
                intermediateCode
                        .add(new IntermedianCode(Code.ASSIGN, symbol.getLocation(), null, tmpVar.getLocation()));

                // Devolvemos la variable temporal
                return tmpVar.getLocation();
            }

            // Si post es true, es post incremento/decremento

            // Asignamos el valor del simbolo original a la variable temporal
            intermediateCode.add(new IntermedianCode(Code.ASSIGN, symbol.getLocation(), null, tmpVar.getLocation()));

            // Incrementamos el simbolo original
            intermediateCode
                    .add(new IntermedianCode(Code.valueOf(inc.getOperator().name()), null, null, symbol.getLocation()));

            // Devolvemos la variable temporal
            return tmpVar.getLocation();

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

            explore(ifNode.getIfBody(), intermediateCode); // Exploramos el cuerpo del if

            intermediateCode.add(new IntermedianCode(Code.JMP, null, null, etiqueta_fin)); // Si la condicion es falsa,
                                                                                           // salta a la etiqueta

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_else)); // Etiqueta para el salto
                                                                                              // si la condicion es
                                                                                              // falsa

            if (ifNode.getElseBody() != null) {
                explore(ifNode.getElseBody(), intermediateCode); // Exploramos el cuerpo del else
            }

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_fin)); // Etiqueta para el salto
                                                                                             // al final del if

            return null;

        }

        if (node instanceof ForNode) {

            ForNode forNode = (ForNode) node;

            String etiqueta_inicio = makeNewEtiqueta(); // Etiqueta para el inicio del for
            String etiqueta_fin = makeNewEtiqueta(); // Etiqueta para el final del for

            if (forNode.getInit() != null) {
                explore(forNode.getInit(), intermediateCode); // Exploramos la inicializacion del for
            }

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_inicio)); // Etiqueta para el
            // inicio del for

            if (forNode.getCondition() != null) {
                String condition = explore(forNode.getCondition(), intermediateCode); // Contiene el resultado de la
                                                                                      // condicion en una var

                intermediateCode.add(new IntermedianCode(Code.JEQ, condition, "0", etiqueta_fin)); // Si la condicion es
                // falsa, salta a la
                // etiqueta
            }

            explore(forNode.getBody(), intermediateCode); // Exploramos el cuerpo del for

            if (forNode.getIncrement() != null) {
                explore(forNode.getIncrement(), intermediateCode); // Exploramos el incremento del for
            }

            intermediateCode.add(new IntermedianCode(Code.JMP, null, null, etiqueta_inicio)); // Salta al inicio del for

            intermediateCode.add(new IntermedianCode(Code.LABEL, null, null, etiqueta_fin)); // Etiqueta para el final
            // del for

            return null;
        }

        if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;

            String value = explore(assign.getValue(), intermediateCode);

            intermediateCode
                    .add(new IntermedianCode(Code.ASSIGN, value, null, assign.getVar().getLocation()));

            return assign.getVar().getLocation();
        }

        if (node instanceof ExpresionNode) {
            ExpresionNode exp = (ExpresionNode) node;

            String left = explore(exp.getLeft(), intermediateCode);
            String right = explore(exp.getRight(), intermediateCode);

            GrapeSymbol tmpVar = makeNewTmpVar(exp.getTipo());

            intermediateCode.add(
                    new IntermedianCode(Code.valueOf(exp.getOperator().name()), left, right, tmpVar.getLocation()));

            return tmpVar.getLocation();
        }

        if (node instanceof FuncNode) {
            FuncNode func = (FuncNode) node;
            List<IntermedianCode> funcCode = new ArrayList<>();

            // Exploramos los parametros
            for (Node n : func.getParameters()) {
                explore(n, funcCode);
            }

            // Indicamos que estamos dentro de una funcion
            symTable.enterFunction(symTable.getFunction(func.getName()));

            // Exploramos el cuerpo de la funcion

            explore(func.getBody(), funcCode);

            FunctionSymbol function = symTable.getFunction(func.getName());
            function.setFuncCode(funcCode);

            return null;
        }

        if (node instanceof FuncCallNode) {
            FuncCallNode funcCall = (FuncCallNode) node;

            // Llamamos a la funcion
            intermediateCode.add(new IntermedianCode(Code.CALL, null, null, funcCall.getFuncSymbol().getName()));

            return funcCall.getFuncSymbol().getReturnSymbol().getLocation();

        }

        if (node instanceof ReturnFuncNode) {
            ReturnFuncNode returnFunc = (ReturnFuncNode) node;

            if (!symTable.hasFunctions()) {
                throw new RuntimeException("Return statement outside of a function");
            }

            String value = explore(returnFunc.getReturnNode(), intermediateCode);

            intermediateCode.add(new IntermedianCode(Code.RETURN, value, null,
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

    public static GrapeSymbol makeNewTmpVar(UnderlyingSymbolType type, SymbolTable symTable) {
        GrapeSymbol tmpVar = new GrapeSymbol("T" + numTmpVar++, SymbolType.ARRAY, type, 1, 0);

        symTable.addVariable(tmpVar);

        return tmpVar;
    }

}
