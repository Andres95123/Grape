package com.grape.utils.AST;

public class BinaryOpNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;
    private OpType operator;

    public BinaryOpNode(ExpressionNode left, ExpressionNode right, OpType operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public OpType getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "BinaryOpNode{" +
                "left=" + left +
                ", right=" + right +
                ", operator='" + operator + '\'' +
                '}';
    }
}
