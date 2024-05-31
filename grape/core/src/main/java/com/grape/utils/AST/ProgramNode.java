package com.grape.utils.AST;

import com.grape.utils.Tipo;

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

    @Override
    public boolean isType(Tipo type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isType'");
    }

    

    @Override
    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.getCode());
        }
        return sb.toString();
    }

    @Override
    public Tipo getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

}
