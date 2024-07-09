package com.grape.utils.AST;

public enum Operadores {
    // Operadores Ariméticos
    ASSIGN, ADD, POST_ADD, SUB, POST_SUB, MUL, DIV, MOD,
    // Operadores Lógicos
    AND, OR, NOT,
    // Operadores Relacionales
    EQ, NEQ, GT, LT, GE, LE;

    // Si es un post, devuelve true
    public boolean isPostOp() {
        return this == POST_ADD || this == POST_SUB;
    }

    public boolean isArithmeticOp() {
        return this == ADD || this == SUB || this == MUL || this == DIV || this == MOD;
    }

    public boolean isRelationalOp() {
        return this == EQ || this == NEQ || this == GT || this == LT || this == GE || this == LE;
    }
}
