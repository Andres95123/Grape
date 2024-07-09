package com.grape.utils.AST.Comandos;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Definiciones.DefineNode;
import com.grape.utils.AST.Definiciones.VariableNode;

public class IncrementNode extends DefineNode {

    VariableNode variable;
    Comandos op;

    public IncrementNode(VariableNode variable, Comandos op) {
        this.variable = variable;
        this.op = op;
    }

    public VariableNode getVariable() {
        return variable;
    }

    public Comandos getOp() {
        return op;
    }

    @Override
    public Tipo getType() {
        // Devolvemos el tipo de la variable
        return variable.getType();
    }

    @Override
    public boolean isType(Tipo type) {
        return this.getType() == type;
    }

}
