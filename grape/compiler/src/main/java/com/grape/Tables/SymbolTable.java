package com.grape.Tables;

import java.util.HashMap;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;

public class SymbolTable {

    HashMap<String, GrapeSymbol> varTable;
    HashMap<String, FunctionSymbol> funcTable;

    public SymbolTable() {
        varTable = new HashMap<>();
        funcTable = new HashMap<>();
    }

    public void addVariable(GrapeSymbol symbol) {

        if (!isSymbolUsed(symbol.getName())) {
            varTable.put(symbol.getName(), symbol);
        }

    }

    public GrapeSymbol getVariable(String name) {
        return varTable.get(name);
    }

    public boolean containsSymbol(String name) {
        return varTable.containsKey(name);
    }

    // get Iterator
    public GrapeSymbol[] getSymbols() {
        return varTable.values().toArray(new GrapeSymbol[0]);
    }

    // Funciones

    public void addFunction(FunctionSymbol function) {
        if (!isSymbolUsed(function.getName())) {
            funcTable.put(function.getName(), function);
        }
    }

    public FunctionSymbol getFunction(String name) {
        return funcTable.get(name);
    }

    public boolean containsFunction(String name) {
        return funcTable.containsKey(name);
    }

    // get Iterator

    public FunctionSymbol[] getFunctions() {
        return funcTable.values().toArray(new FunctionSymbol[0]);
    }

    private boolean isSymbolUsed(String symbol) {
        // Comprovar si ya existe la var
        if (varTable.containsKey(symbol)) {
            throw new RuntimeException("Variable " + symbol + " already exists");
        }

        // Comprovar si ya existe la funcion
        if (funcTable.containsKey(symbol)) {
            throw new RuntimeException("Function " + symbol + " already exists");
        }

        return false;
    }

}
