package com.grape.utils.AST;

public class BlockNode extends Node {

    Node[] nodes;

    public BlockNode(Node node) {
        this.nodes = new Node[] { node };
    }

    public BlockNode(Node node, BlockNode block) {
        this.nodes = new Node[block.nodes.length + 1];
        System.arraycopy(block.nodes, 0, this.nodes, 0, block.nodes.length);
        this.nodes[block.nodes.length] = node;
    }

    public BlockNode(Node node, Node[] nodes) {
        this.nodes = new Node[nodes.length + 1];
        this.nodes[0] = node;
        System.arraycopy(nodes, 0, this.nodes, 1, nodes.length);
    }

    public Node[] getNodes() {
        return nodes;
    }

}
