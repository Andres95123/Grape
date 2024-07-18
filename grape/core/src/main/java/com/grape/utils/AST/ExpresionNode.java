package com.grape.utils.AST;

import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.Operator;

public class ExpresionNode extends ReturnNode {

    private ReturnNode left;
    private ReturnNode right;
    private Operator operator;

    public ExpresionNode(ReturnNode left, ReturnNode right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public ReturnNode getLeft() {
        return left;
    }

    public ReturnNode getRight() {
        return right;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        if (left.getTipo() == right.getTipo()) {
            return left.getTipo();
        }

        throw new RuntimeException("Error de tipos en la expresion");
    }

}
