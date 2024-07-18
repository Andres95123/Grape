package com.grape.utils.AST;

import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class VarNode extends ReturnNode {

    private GrapeSymbol symbol;
    private ReturnNode value;

    public VarNode(GrapeSymbol symbol, ReturnNode value) {
        this.symbol = symbol;
        this.value = value;
    }

    public GrapeSymbol getSymbol() {
        return symbol;
    }

    public ReturnNode getValue() {
        return value;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return symbol.getSubtype();
    }

}
