package com.grape.utils.AST.Estructuras;

import java.util.ArrayDeque;

import com.grape.utils.AST.Node;

public class IfNode extends EstructuraControl {

    private Node condition;

    private EstructuraControl[] ifBody;
    private EstructuraControl[] elseBody;

    public IfNode(Node condition, ArrayDeque<EstructuraControl> ifBody, ArrayDeque<EstructuraControl> elseBody) {
        this.condition = condition;
        this.ifBody = ifBody.toArray(new EstructuraControl[0]);
        this.elseBody = elseBody.toArray(new EstructuraControl[0]);
    }

    public IfNode(Node condition, ArrayDeque<EstructuraControl> ifBody) {
        this.condition = condition;
        this.ifBody = ifBody.toArray(new EstructuraControl[0]);
        this.elseBody = null;
    }

    public void setElseBody(ArrayDeque<EstructuraControl> elseBody) {

        if (elseBody == null) {
            this.elseBody = null;
            return;
        }

        this.elseBody = elseBody.toArray(new EstructuraControl[0]);
    }

    public Node getCondition() {
        return condition;
    }

    public EstructuraControl[] getIfBody() {
        return ifBody;
    }

    public EstructuraControl[] getElseBody() {
        return elseBody;
    }

}
