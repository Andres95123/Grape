package com.grape.utils.AST.Comandos;

import com.grape.utils.Operator;

public class IncrementNode extends Comando {

    private String symbol;
    private Operator operator;
    private boolean post; // Indica si es pre o post incremento, si es post es true

    public IncrementNode(String symbol, Operator operator, boolean post) {
        this.symbol = symbol;
        this.operator = operator;
        this.post = post;
    }

    public String getSymbol() {
        return symbol;
    }

    public Operator getOperator() {
        return operator;
    }

    public boolean isPost() {
        return post;
    }

}
