package com.grape.Symbols;

public class GrapeSymbol {

    private String name;
    private SymbolType type;
    private UnderlyingSymbolType subtype;
    private int size;
    private int scope;

    public GrapeSymbol(String name, SymbolType type, UnderlyingSymbolType subtype, double size, double scope) {
        this.name = name;
        this.type = type;
        this.subtype = subtype;
        this.size = (int) size;
        this.scope = (int) scope;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return "[" + name + "]";
    }

    public String getLocation(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException(
                    "Index out of bounds in " + name + " with index " + index);
        }

        if (index == 0) {
            return getLocation();
        }

        return "[" + name + "+" + index * UnderlyingSymbolType.getSize(subtype) + "]";
    }

    public SymbolType getType() {
        return type;
    }

    public UnderlyingSymbolType getSubtype() {
        return subtype;
    }

    public int getSize() {
        return size;
    }

    public int getScope() {
        return scope;
    }

}
