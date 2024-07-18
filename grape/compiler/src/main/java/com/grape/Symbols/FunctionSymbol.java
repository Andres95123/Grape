package com.grape.Symbols;

import java.util.List;

import com.grape.IntermedianCode.IntermedianCode;

public class FunctionSymbol {

    String name;
    Object[] parameters;
    GrapeSymbol returnSymbol;

    List<IntermedianCode> intermedianCode;

    public FunctionSymbol(String name, Object[] parameters, GrapeSymbol returnSymbol) {
        this.name = name;
        this.parameters = parameters;
        this.returnSymbol = returnSymbol;

    }

    public GrapeSymbol getReturnSymbol() {
        return returnSymbol;
    }

    public String getName() {
        return name;
    }

    public UnderlyingSymbolType getReturnType() {
        return returnSymbol.getSubtype();
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setFuncCode(List<IntermedianCode> intermedianCode) {
        this.intermedianCode = intermedianCode;
    }

    public List<IntermedianCode> getIntermedianCode() {
        return intermedianCode;
    }

}
