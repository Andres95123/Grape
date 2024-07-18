package com.grape.utils.AST;

import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.Operator;

public class IncrementNode extends ReturnNode {

    private GrapeSymbol symbol;
    private Operator operator;
    private boolean post; // Indica si es pre o post incremento, si es post es true

    public IncrementNode(GrapeSymbol symbol, Operator operator, boolean post) {
        this.symbol = symbol;
        this.operator = operator;
        this.post = post;
    }

    public GrapeSymbol getSymbol() {
        return symbol;
    }

    public Operator getOperator() {
        return operator;
    }

    public boolean isPost() {
        return post;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return symbol.getSubtype();
    }
}
