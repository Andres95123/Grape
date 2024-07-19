package com.grape.utils.AST.Estructuras;

import com.grape.utils.AST.Node;

public class ForNode extends EstructuraControl {

    private Node init;
    private Node condition;
    private Node increment;
    private EstructuraControl body;

    public ForNode(Node init, Node condition, EstructuraControl body, Node increment) {
        this.init = init;
        this.condition = condition;
        this.body = body;
        this.increment = increment;
    }

    public Node getInit() {
        return init;
    }

    public Node getCondition() {
        return condition;
    }

    public Node getIncrement() {
        return increment;
    }

    public EstructuraControl getBody() {
        return body;
    }

}
