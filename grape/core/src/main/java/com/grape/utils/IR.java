package com.grape.utils;

import java.util.Deque;

// Codigo Intermedio (Intermediate Representation)
public class IR {

    public static Deque<IR> irDeque = new java.util.ArrayDeque<>();

    OpCode opCode;
    Object arg1;
    Object arg2;
    Var result;

    public IR(OpCode opCode, Object arg1, Object arg2, Var result) {

        this.opCode = opCode;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
        // Agregar a la lista de instrucciones
        irDeque.add(this);
    }

    @Override
    public String toString() {
        return opCode + " " + arg1 + " " + arg2 + " " + result;
    }

}
