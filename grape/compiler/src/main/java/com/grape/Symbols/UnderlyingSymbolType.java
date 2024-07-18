package com.grape.Symbols;

public enum UnderlyingSymbolType {

    INT, FLOAT, CHAR, STRING, BOOL, NULL;

    public static String toAsemblyOperation(UnderlyingSymbolType type, boolean instanced) {
        // Sección .data
        if (instanced) {

            switch (type) {
                case INT:
                case FLOAT:
                    return "dd";
                case STRING:
                case BOOL:
                    return "db";
                default:
                    return "ERROR";
            }

        }

        // Sección .bss
        switch (type) {
            case INT:
            case FLOAT:
                return "resq";
            case STRING:
            case BOOL:
                return "resb";
            default:
                return "ERROR";
        }
    }

    public static int getSize(UnderlyingSymbolType type) {
        switch (type) {
            case INT:
            case FLOAT:
                return 4;
            case STRING:
            case BOOL:
                return 1;
            default:
                return 0;
        }
    }

}
