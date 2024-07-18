package com.grape.utils.AST;

public class BlockNode extends Node {
    private Node[] nodes;

    public BlockNode(Node[] nodes) {
        this.nodes = nodes;
    }

    public BlockNode(Node e1) {
        this.nodes = new Node[1];
        this.nodes[0] = e1;
    }

    public BlockNode(Node e1, Node e2) {
        this.nodes = new Node[2];
        this.nodes[0] = e1;
        this.nodes[1] = e2;

    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

}
