package com.grape.utils.AST;

import com.grape.Symbols.GrapeSymbol;

public class FuncArgsNode extends Node {

    private Node[] args;

    public FuncArgsNode(Node[] args) {
        this.args = args;
    }

    public FuncArgsNode(Node arg) {
        this.args = new Node[1];
        this.args[0] = arg;
    }

    public FuncArgsNode(Node arg, Node arg2) {
        this.args = new Node[2];
        this.args[0] = arg;
        this.args[1] = arg2;
    }

    public Node[] getArgs() {
        return args;
    }
}
