package com.grape.utils;

import java.util.HashMap;

public class Bloque {

    HashMap<String, Var> vars;

    public Bloque() {
        vars = new HashMap<>();
    }

    public Bloque(Bloque bloqueSuperior) {
        vars = new HashMap<>();
        for (String nombre : bloqueSuperior.vars.keySet()) {
            vars.put(nombre, bloqueSuperior.vars.get(nombre));
        }
    }

    public void addVar(String nombre, Tipo tipo, Object valor) {
        vars.put(nombre, new Var(tipo, nombre, valor));
    }

    public Var getVar(String nombre) {
        return vars.get(nombre);
    }

    public boolean existeVar(String nombre) {
        return vars.containsKey(nombre);
    }

    @Override
    public String toString() {
        return vars.toString();
    }

}
