package com.grape.utils.AST;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class FuncNode extends Node {

    private FunctionSymbol functionSym;
    private BlockNode body;

    public FuncNode(FunctionSymbol funcSym, BlockNode body) {
        this.functionSym = funcSym;
        this.body = body;
    }

    public String getName() {
        return functionSym.getName();
    }

    public BlockNode getBody() {
        return body;
    }

    public UnderlyingSymbolType getReturnType() {
        return functionSym.getReturnType();
    }

    public Node[] getParameters() {
        return (Node[]) functionSym.getParameters();
    }

}
