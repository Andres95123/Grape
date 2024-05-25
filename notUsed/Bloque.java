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

    public void addVar(String nombre, Var var) {
        vars.put(nombre, var);
    }

    public Var getVar(String nombre) {

        if (!vars.containsKey(nombre)) {
            throw new RuntimeException("Variable " + nombre + " no definida");
        }

        return vars.get(nombre);
    }

    @Override
    public String toString() {
        return vars.toString();
    }

}
