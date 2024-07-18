package com.grape.utils.AST;

import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class AddressNode extends ReturnNode {

    private GrapeSymbol symbol;

    public AddressNode(GrapeSymbol symbol) {
        this.symbol = symbol;
    }

    public GrapeSymbol getSymbol() {
        return symbol;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return symbol.getSubtype();
    }

}
