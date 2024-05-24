package com.grape.utils;

public class Var {

    private Tipo tipo;
    private String nombre;
    private Object valor;

    public Var(Tipo tipo, String nombre, Object valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }

    public boolean esTipo(Tipo tipo) {
        return this.tipo == tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return tipo + ":" + valor;
    }

}
