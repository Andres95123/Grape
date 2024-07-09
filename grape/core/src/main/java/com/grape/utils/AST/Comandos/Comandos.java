package com.grape.utils.AST.Comandos;

public enum Comandos {

    // Arithmetic
    ASSIGN, ADD, POST_ADD, SUB, POST_SUB, MUL, DIV, MOD, POW,

    // IFS
    IF_GE, IF_GT, IF_LE, IF_LT, IF_EQ, IF_NEQ,

    // Jumps
    ETIQUETA, GOTO;

    // Si es un post, devuelve true
    public boolean isPostOp() {
        return this == POST_ADD || this == POST_SUB;
    }

}
