package com.grape.utils.AST.Definiciones;

import com.grape.utils.AST.BlockNode;
import com.grape.utils.AST.Node;

public class FunctionNode extends Node {

    private String name;
    private BlockNode block;

    public FunctionNode(String name, BlockNode block) {
        this.name = name;
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public BlockNode getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "FunctionNode{" +
                "name='" + name + '\'' +
                ", block=" + block +
                '}';
    }

}
