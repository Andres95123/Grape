package com.grape.utils.AST;

public class ReturnFuncNode extends Node {

    ReturnNode returnNode;

    public ReturnFuncNode(ReturnNode returnNode) {
        this.returnNode = returnNode;
    }

    public ReturnNode getReturnNode() {
        return returnNode;
    }

}
