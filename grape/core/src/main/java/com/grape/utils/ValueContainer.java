package com.grape.utils;

import com.grape.Symbols.UnderlyingSymbolType;

public class ValueContainer {
    Object value;
    UnderlyingSymbolType type;

    public ValueContainer(Object value, UnderlyingSymbolType type) {
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public UnderlyingSymbolType getType() {
        return type;
    }

    public boolean isType(UnderlyingSymbolType type) {
        return this.type == type;
    }

    public void changeType(UnderlyingSymbolType type) {
        this.type = type;
    }

}
