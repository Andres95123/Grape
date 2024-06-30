package com.grape.utils.AST.Definiciones;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Node;
import com.grape.utils.AST.Operadores;

public class ExpresionNode extends DefineNode {

    Node left;
    Node right;
    Operadores op;

    public ExpresionNode(Node left, Node right, Operadores op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Tipo getType() {
        Tipo leftTipe;

        if (left instanceof ValueNode) {
            leftTipe = ((ValueNode) left).getType();
        } else if (left instanceof VariableNode) {
            leftTipe = ((VariableNode) left).getType();
        } else if (left instanceof ExpresionNode) {
            leftTipe = ((ExpresionNode) left).getType();
        } else {
            leftTipe = Tipo.ERROR;
        }

        Tipo rightTipe;

        if (right instanceof ValueNode) {
            rightTipe = ((ValueNode) right).getType();
        } else if (right instanceof VariableNode) {
            rightTipe = ((VariableNode) right).getType();
        } else if (right instanceof ExpresionNode) {
            rightTipe = ((ExpresionNode) right).getType();
        } else {
            rightTipe = Tipo.ERROR;
        }

        if (leftTipe == Tipo.ERROR || rightTipe == Tipo.ERROR || leftTipe != rightTipe) {
            return Tipo.ERROR;
        }

        return leftTipe;

    }

    public boolean isType(Tipo type) {
        return this.getType() == type;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Operadores getOp() {
        return op;
    }

}
