package com.grape.utils;

import java.util.HashMap;

public class Bloque {
    HashMap<String, Tipo> variables;

    public Bloque() {
        variables = new HashMap<>();
    }

    public void addVariable(String name, Tipo type) {
        if (variables.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " already defined in this scope");
        }
        variables.put(name, type);
    }

    public Tipo getVariable(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        throw new RuntimeException("Variable " + name + " not found defined in this scope");
    }

}
