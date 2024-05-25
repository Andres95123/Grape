package com.grape.utils.AST;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends Node {
    List<StatementNode> statements;

    public ProgramNode(StatementNode statement) {
        this.statements = new ArrayList<>();
        this.statements.add(statement);
    }

    public ProgramNode(StatementNode statement, ProgramNode program) {
        this.statements = new ArrayList<>();
        this.statements.add(statement);
        this.statements.addAll(program.statements);
    }

    public List<StatementNode> getStatements() {
        return statements;
    }
}
