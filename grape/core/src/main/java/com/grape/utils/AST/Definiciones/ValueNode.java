package com.grape.utils.AST.Definiciones;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Node;

import java_cup.reduce_action;

public class ValueNode extends DefineNode {
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

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
