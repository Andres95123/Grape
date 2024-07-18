package com.grape.utils.AST;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class FuncCallNode extends ReturnNode {

    private FunctionSymbol functionName;
    private ReturnNode[] parameters;

    public FuncCallNode(FunctionSymbol functionName, ReturnNode[] parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }

    public FunctionSymbol getFuncSymbol() {
        return functionName;
    }

    public ReturnNode[] getParameters() {
        return parameters;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return functionName.getReturnType();
    }

}
