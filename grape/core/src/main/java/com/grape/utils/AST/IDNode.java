package com.grape.utils.AST;

public class IDNode extends ExpressionNode {

    private String id;

    public IDNode(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

}
