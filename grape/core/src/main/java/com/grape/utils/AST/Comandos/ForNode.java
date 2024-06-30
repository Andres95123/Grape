package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Node;

public class ForNode extends Node {

    public Node init;
    public Node condition;
    public Node body;
    public Node increment;

    public ForNode(Node init, Node condition, Node body, Node increment) {
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.body = body;
    }

    public Node getInit() {
        return init;
    }

    public Node getCondition() {
        return condition;
    }

    public Node getBody() {
        return body;
    }

    public Node getIncrement() {
        return increment;
    }

}
