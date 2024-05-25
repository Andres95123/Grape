package com.grape.utils.AST;

public class OpNode extends StatementNode {

    private String variable;
    private OpType type;
    private ExpressionNode expression;

    public OpNode(String variable, OpType op, ExpressionNode expression) {
        this.variable = variable;
        this.type = op;
        this.expression = expression;
    }

    public String getVariable() {
        return variable;
    }

    public OpType getOp() {
        return type;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return variable + " " + type.name() + " " + expression;
    }

}


