package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Node;

public class AssignNode extends Node {

    Node left;
    Node right;

    public AssignNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

}
