package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Node;

public class AssignNode extends Comando {

    private String var;
    private Node value;

    public AssignNode(String var, Node value) {
        this.var = var;
        this.value = value;
    }

    public String getVar() {
        return var;
    }

    public Node getValue() {
        return value;
    }

}
