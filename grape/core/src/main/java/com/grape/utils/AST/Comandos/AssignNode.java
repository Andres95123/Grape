package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Node;

public class AssignNode extends Comando {

    private String var;
    private Node value;
    private Node index;

    public AssignNode(String var, Node index, Node value) {
        this.var = var;
        this.value = value;
        this.index = index;
    }

    public String getVar() {
        return var;
    }

    public Node getValue() {
        return value;
    }

    public Node getIndex() {
        return index;
    }

}
