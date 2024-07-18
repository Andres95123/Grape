package com.grape.utils.AST;

public class IfNode extends Node {

    private ReturnNode condition;

    private BlockNode ifBody;
    private BlockNode elseBody;

    public IfNode(ReturnNode condition, BlockNode ifBody, BlockNode elseBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public IfNode(ReturnNode condition, BlockNode ifBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = null;
    }

    public ReturnNode getCondition() {
        return condition;
    }

    public BlockNode getIfBody() {
        return ifBody;
    }

    public BlockNode getElseBody() {
        return elseBody;
    }

}
