package com.grape.utils.AST;

import com.grape.utils.Tipo;

public class IfNode extends Node {

    Node condition;
    Node ifBody;
    Node elseBody;

    public IfNode(Node condition, Node ifBody, Node elseBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public boolean isType(Tipo type) {
        return false;
    }

    @Override
    public Tipo getType() {
        return null;
    }

    @Override
    public String getCode() {
        return "if(" + condition.getCode() + "){\n" + ifBody.getCode() + "}\n"
                + (elseBody != null ? "else{\n" + elseBody.getCode() + "}\n" : "");
    }

}
