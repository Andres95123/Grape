package com.grape.utils.AST.Estructuras;

import java.util.Stack;

import com.grape.utils.AST.Node;

public class BloqueComando extends EstructuraControl {
    private Stack<Node> stack;

    public BloqueComando() {
        stack = new Stack<>();
    }

    public BloqueComando(Node nodes) {
        stack = new Stack<>();
        stack.push(nodes);
    }

    public void addComando(Node node) {
        stack.push(node);
    }

    public Node[] getNodes() {
        return stack.toArray(new Node[0]);
    }

}
