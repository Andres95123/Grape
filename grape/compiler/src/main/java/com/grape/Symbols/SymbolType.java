package com.grape.Symbols;

public enum SymbolType {

    ARRAY, FUNCTION, STRUCT, UNKNOWN;

    public static SymbolType fromString(String type) {
        switch (type) {
            case "array":
                return ARRAY;
            case "function":
                return FUNCTION;
            case "struct":
                return STRUCT;
            default:
                return UNKNOWN;
        }
    }

    public static String toString(SymbolType type) {
        switch (type) {
            case ARRAY:
                return "array";
            case FUNCTION:
                return "function";
            case STRUCT:
                return "struct";
            default:
                return "unknown";
        }
    }

}
