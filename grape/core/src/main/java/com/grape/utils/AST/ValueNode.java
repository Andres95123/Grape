package com.grape.utils.AST;

import com.grape.utils.Tipo;

public class ValueNode extends ExpressionNode {

    Tipo tipo;
    Object valor;

    public ValueNode(Tipo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return tipo + ":" + valor;
    }

}
