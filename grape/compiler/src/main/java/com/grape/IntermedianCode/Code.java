package com.grape.IntermedianCode;

import com.grape.Symbols.UnderlyingSymbolType;

public enum Code {

    // Funciones aritmeticas basicas
    ADD, SUB, MUL, DIV, MOD,

    // Operaciones logicas
    AND, OR, NOT,

    // Relacionales
    EQ, NE, GT, LT, GE, LE,

    // Asignacion
    ASSIGN, ASSIGN_INDEX, ASSIGN_FLOAT,

    // Operaciones Rapidas
    INCREMENT, DECREMENT,

    // Funciones
    CALL, RETURN,

    // Etiquetas
    LABEL, JMP, JEQ, JNE,

    // Stack
    PUSH, POP,
    // Debugging
    PRINT,

    // Funciones coma flotante
    FADD, FSUB, FMUL, FDIV, FMOD;



    // Funcion que dado el undertype de int o float devuelve assign o assign_float
    public static Code getAssign(UnderlyingSymbolType tipo) {
        if (tipo == UnderlyingSymbolType.INT) {
            return ASSIGN;
        } else if (tipo == UnderlyingSymbolType.FLOAT) {
            return ASSIGN_FLOAT;
        }
        throw new RuntimeException("Tipo no soportado");
    }

}
