package com.grape.utils;

import java.util.Stack;

import com.grape.utils.AST.*;

public class ASTAnalyzer {

    Stack<Bloque> pilaBloques = new Stack<>();

    public ASTAnalyzer(ProgramNode program) {

        // Primer bloque
        pilaBloques.push(new Bloque());

        for (StatementNode statement : program.getStatements()) {
            analyze(statement);
        }
    }

    private void analyze(StatementNode statement) {

        if (statement instanceof OpNode) {
            analyzeOpNode((OpNode) statement);
        } else {
            throw new RuntimeException("Unknown statement type: " + statement.getClass());
        }

    }

    public void analyzeOpNode(OpNode opNode) {
        switch (opNode.getOp()) {
            case ASSIGN:
                // Analyze expression
                ValueContainer tmp1 = analyze(opNode.getExpression());
                // Create variable
                pilaBloques.peek().addVariable(opNode.getVariable(), tmp1.getType());

                break;
        }
    }

    private ValueContainer analyze(ExpressionNode expression) {
        if (expression instanceof BinaryOpNode) {
            ValueContainer tmp1 = analyze(((BinaryOpNode) expression).getLeft());
            ValueContainer tmp2 = analyze(((BinaryOpNode) expression).getRight());

            if (tmp1.getType() == Tipo.ADDR) {
                tmp1.changeType(pilaBloques.peek().getVariable((String) tmp1.getValue()));
            }

            if (tmp2.getType() == Tipo.ADDR) {
                tmp2.changeType(pilaBloques.peek().getVariable((String) tmp2.getValue()));
            }

            if (tmp1.getType() != tmp2.getType()) {
                throw new RuntimeException("Type mismatch in binary operation" + expression);
            }
            return tmp1;
        } else if (expression instanceof ValueNode) {
            // Do nothing
            return new ValueContainer(((ValueNode) expression).getValor(), ((ValueNode) expression).getTipo());
        } else if (expression instanceof IDNode) {
            // Do nothing
            return new ValueContainer(null, pilaBloques.peek().getVariable(((IDNode) expression).getID()));
        } else {
            throw new RuntimeException("Unknown expression type: " + expression.getClass());
        }
    }
}
