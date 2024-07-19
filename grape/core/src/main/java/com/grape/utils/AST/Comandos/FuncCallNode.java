package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Base.Expresion;

public class FuncCallNode extends Comando {

    private String functionName;
    private Expresion[] parameters;

    public FuncCallNode(String functionName, Expresion[] parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }

    public String getFuncSymbol() {
        return functionName;
    }

    public Expresion[] getParameters() {
        return parameters;
    }

}
