package com.grape.utils;

import java.util.ArrayList;

public class Var {

    private static long temporalVars = 0;

    private Tipo tipo;
    private String nombre;
    private Object valor;

    // Constructor de variables del usuario
    public Var(Tipo tipo, String nombre, Object valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;

        new IR(OpCode.ASSIGN, valor, null, this);
    }

    // Constructor de variables temporales
    public Var(Tipo tipo, Object valor, boolean assign) {
        this.tipo = tipo;
        this.nombre = "t" + temporalVars++;
        this.valor = valor;

        if (assign) {
            new IR(OpCode.ASSIGN, valor, null, this);
        }
    }

    public boolean isType(Tipo tipo) {
        return this.tipo == tipo;
    }

    public Tipo getType() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.nombre + " = " + tipo + ":" + valor;
    }

    public Var sumar(Var other) {

        if (this.tipo != other.tipo) {
            throw new RuntimeException("No se pueden sumar variables de distinto tipo");
        }

        Var destino = new Var(tipo, null, false);
        new IR(OpCode.ADD, this, other, destino);

        return destino;
    }

    public Var restar(Var other) {
        if (this.tipo != other.tipo) {
            throw new RuntimeException("No se pueden restar variables de distinto tipo");
        }

        Var destino = new Var(tipo, null, false);
        new IR(OpCode.SUB, this, other, destino);

        return destino;
    }

    public Var multiplicar(Var other) {

        if (this.tipo != other.tipo) {
            throw new RuntimeException("No se pueden multiplicar variables de distinto tipo");
        }

        Var destino = new Var(tipo, null, false);
        new IR(OpCode.MUL, this, other, destino);

        return destino;

    }

    public Var dividir(Var other) {

        if (this.tipo != other.tipo) {
            throw new RuntimeException("No se pueden dividir variables de distinto tipo");
        }



        Var destino = new Var(tipo, null, false);
        new IR(OpCode.DIV, this, other, destino);

        return destino;
    }

    public Var modulo(Var other) {

        if (this.tipo != other.tipo) {
            throw new RuntimeException("No se pueden dividir variables de distinto tipo");
        }

        Var destino = new Var(tipo, null, false);
        new IR(OpCode.MOD, this, other, destino);

        return destino;
    }

}
