package com.grape.Symbols;

public class ConstantSymbol extends GrapeSymbol {

    private Object value;

    public ConstantSymbol(String name, SymbolType type, UnderlyingSymbolType subtype, int size, int scope,
            Object value) {
        super(name, type, subtype, size, scope);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
