package com.grape.utils.AST;

import com.grape.utils.Tipo;

import java_cup.reduce_action;

public class ValueNode extends Node {
    Object value;
    Tipo type;

    public ValueNode(Object value, Tipo type) {
        this.value = value;
        this.type = type;
    }

    public boolean isType(Tipo type) {
        return this.type == type;
    }

    public Tipo getType() {
        return type;
    }

    @Override
    public String getCode() {
        return value.toString();
    }
}
