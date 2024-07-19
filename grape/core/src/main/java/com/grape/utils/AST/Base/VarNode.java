package com.grape.utils.AST.Base;

import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.AST.Node;

public class VarNode extends Expresion {

    private GrapeSymbol symbol;
    private Node value;

    public VarNode(GrapeSymbol symbol, Node value) {
        this.symbol = symbol;
        this.value = value;
    }

    public GrapeSymbol getSymbol() {
        return symbol;
    }

    public Node getValue() {
        return value;
    }

    public boolean isNull() {
        return value == null;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return symbol.getSubtype();
    }

}
