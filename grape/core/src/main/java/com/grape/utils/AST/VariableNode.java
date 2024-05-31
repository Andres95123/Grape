package com.grape.utils.AST;

import com.grape.utils.Tipo;

import java_cup.reduce_action;

public class VariableNode extends Node {

    String name;
    Node value;
    Tipo type;

    public VariableNode(String name, Node value, Tipo type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isType(Tipo type) {
        return this.type == type;
    }

    @Override
    public String getCode() {
        return name + " = " + value.getCode() + ";" + "\n";
    }

    @Override
    public Tipo getType() {
        return type;
    }

}
