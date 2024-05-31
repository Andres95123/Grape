package com.grape.utils.AST;

import com.grape.utils.Tipo;

public class ExpresionNode extends Node {

    Node left;
    Node right;
    Operadores op;

    public ExpresionNode(Node left, Node right, Operadores op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public boolean isType(Tipo type) {
        return left.isType(type) && right.isType(type);
    }

    public Tipo getType() {
        return left.getType() == right.getType() ? left.getType() : Tipo.ERROR;
    }

    @Override
    public String getCode() {
        return left.getCode() + " " + op + " " + right.getCode();
    }

}
