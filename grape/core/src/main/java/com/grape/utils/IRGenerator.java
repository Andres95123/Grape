package com.grape.utils;

import com.grape.utils.AST.*;

import java.util.ArrayList;
import java.util.List;

public class IRGenerator {
    public static List<String> generateIR(ProgramNode program) {
        List<String> irCode = new ArrayList<>();
        for (StatementNode statement : program.getStatements()) {
            irCode.addAll(generateIR(statement));
        }
        return irCode;
    }

    private static List<String> generateIR(StatementNode statement) {
        if (statement instanceof OpNode) {
            return generateIR((OpNode) statement);
        } else {
            throw new RuntimeException("Unknown statement type: " + statement.getClass());
        }
    }

    private static List<String> generateIR(OpNode opNode) {
        List<String> irCode = new ArrayList<>();
        irCode.add(opNode.toString());
        return irCode;
    }

}
