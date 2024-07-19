package com.grape.utils.AST.Comandos;

import com.grape.Symbols.FunctionSymbol;
import com.grape.utils.AST.Node;

public class FuncCallNode extends Comando {

    private FunctionSymbol functionName;
    private Node[] parameters;

    public FuncCallNode(FunctionSymbol functionName, Node[] parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }

    public FunctionSymbol getFuncSymbol() {
        return functionName;
    }

    public Node[] getParameters() {
        return parameters;
    }

}
