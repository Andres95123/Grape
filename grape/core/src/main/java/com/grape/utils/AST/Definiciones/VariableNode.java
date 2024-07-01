package com.grape.utils.AST.Definiciones;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Node;

import java_cup.reduce_action;

public class VariableNode extends DefineNode {

    private String name;
    private Node value;
    private Tipo type;

    private boolean instanced;

    public VariableNode(String name, Node value, Tipo type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isType(Tipo type) {
        return this.type == type;
    }

    public Tipo getType() {
        return type;
    }

    public Node getValue() {
        return value;
    }

    public void setInstanced() {
        this.instanced = true;
    }

    public boolean isInstanced() {
        return instanced;
    }


    @Override
    public String toString() {
        // Escribimos el nombre de la var, el tamaño y el valor
        return name + " " + getTamaño() + " " + value;
    }

    private String getTamaño() {
        // Obtenemos el tamaño de la variable
        switch (type) {
            case INT:
            // case FLOAT:
                return "dd";
            case CHAR:
                return "db";
            case STRING:
                return "db";
            default:
                return "4";
        }
    }

}
