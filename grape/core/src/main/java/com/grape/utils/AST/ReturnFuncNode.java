package com.grape.utils.AST;

import com.grape.Symbols.FunctionSymbol;

public class ReturnFuncNode extends Node {

    FunctionSymbol functionSym;
    ReturnNode returnNode;

    public ReturnFuncNode(FunctionSymbol functionSym, ReturnNode returnNode) {
        this.functionSym = functionSym;
        this.returnNode = returnNode;
    }

    public ReturnNode getReturnNode() {
        return returnNode;
    }

    public FunctionSymbol getFunctionName() {
        return functionSym;
    }

}
