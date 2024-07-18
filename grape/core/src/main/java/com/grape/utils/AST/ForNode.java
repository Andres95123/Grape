package com.grape.utils.AST;

public class ForNode extends Node {

    private Node init;
    private ReturnNode condition;
    private Node increment;
    private BlockNode body;

    public ForNode(Node init, ReturnNode condition, BlockNode body, Node increment2) {
        this.init = init;
        this.condition = condition;
        this.body = body;
        this.increment = increment2;
    }

    public Node getInit() {
        return init;
    }

    public ReturnNode getCondition() {
        return condition;
    }

    public Node getIncrement() {
        return increment;
    }

    public BlockNode getBody() {
        return body;
    }

}
