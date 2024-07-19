package com.grape.utils.AST.Estructuras;

import com.grape.utils.AST.Node;

public class IfNode extends EstructuraControl {

    private Node condition;

    private EstructuraControl ifBody;
    private EstructuraControl elseBody;

    public IfNode(Node condition, EstructuraControl ifBody, EstructuraControl elseBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public IfNode(Node condition, EstructuraControl ifBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = null;
    }

    public void setElseBody(EstructuraControl elseBody) {
        this.elseBody = elseBody;
    }

    public Node getCondition() {
        return condition;
    }

    public EstructuraControl getIfBody() {
        return ifBody;
    }

    public EstructuraControl getElseBody() {
        return elseBody;
    }

}
