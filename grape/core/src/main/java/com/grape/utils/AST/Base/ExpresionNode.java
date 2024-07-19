package com.grape.utils.AST.Base;

import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.Operator;
import com.grape.utils.AST.Node;

public class ExpresionNode extends Node {

    private Node left;
    private Node right;
    private Operator operator;

    public ExpresionNode(Node left, Node right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Operator getOperator() {
        return operator;
    }

}
