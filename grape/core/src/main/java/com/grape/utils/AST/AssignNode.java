package com.grape.utils.AST;

import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;

public class AssignNode extends ReturnNode {

    private GrapeSymbol var;
    private ReturnNode value;

    public AssignNode(GrapeSymbol var, ReturnNode value) {
        this.var = var;
        this.value = value;
    }

    public GrapeSymbol getVar() {
        return var;
    }

    public ReturnNode getValue() {
        return value;
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return var.getSubtype();
    }

}
