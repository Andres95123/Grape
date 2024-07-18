package com.grape.utils.AST;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class FuncCallNode extends ReturnNode {

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

    @Override
    public UnderlyingSymbolType getTipo() {
        return functionName.getReturnType();
    }

}
