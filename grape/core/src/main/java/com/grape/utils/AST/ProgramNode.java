package com.grape.utils.AST;

public class ProgramNode extends Node {

    Node[] nodes;

    public ProgramNode(Node nodes) {
        this.nodes = new Node[] { nodes };
    }

    public ProgramNode(Node node, ProgramNode programNode) {
        this.nodes = new Node[programNode.nodes.length + 1];
        System.arraycopy(programNode.nodes, 0, this.nodes, 0, programNode.nodes.length);
        this.nodes[programNode.nodes.length] = node;
    }

    public ProgramNode(Node node, Node[] nodes) {
        this.nodes = new Node[nodes.length + 1];
        this.nodes[0] = node;
        System.arraycopy(nodes, 0, this.nodes, 1, nodes.length);
    }

    public Node[] getNodes() {
        return nodes;
    }

}
