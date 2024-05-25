package com.grape.utils;

public class ValueContainer {
    Object value;
    Tipo type;

    public ValueContainer(Object value, Tipo type) {
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public Tipo getType() {
        return type;
    }

    public boolean isType(Tipo type) {
        return this.type == type;
    }

    public void changeType(Tipo type) {
        this.type = type;
    }

}
