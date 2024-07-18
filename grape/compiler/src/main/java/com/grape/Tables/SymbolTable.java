package com.grape.Tables;

import java.util.HashMap;
import java.util.Stack;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;

public class SymbolTable {

    HashMap<String, GrapeSymbol> varTable;
    HashMap<String, FunctionSymbol> funcTable;

    Stack<FunctionSymbol> functionStack;
    Stack<HashMap<String, GrapeSymbol>> varStack;

    public SymbolTable() {
        varTable = new HashMap<>();
        varStack = new Stack<>();
        varStack.push(varTable);

        funcTable = new HashMap<>();
        functionStack = new Stack<>();
    }

    public void addVariable(GrapeSymbol symbol) {

        if (hasFunctions()) {
            symbol.setName(symbol.getName() + "_" + functionStack.peek().getName());
        }

        if (!isSymbolUsed(symbol.getName())) {

            // Añadimos la variable a la tabla de variables (todos los simbolos)
            varTable.put(symbol.getName(), symbol);

            // Añadimos la variable a la tabla de variables del bloque actual
            varStack.peek().put(symbol.getName(), symbol);

        }

    }

    public GrapeSymbol getVariable(String name) {
        if (!containsSymbol(name)) {
            throw new RuntimeException("Variable " + name + " not found");
        }

        if (hasFunctions()) {
            return varTable.get(name + "_" + functionStack.peek().getName());
        }

        // Buscamos la variable en la tabla de variables del bloque actual
        return varStack.peek().get(name);
    }

    public boolean containsSymbol(String name) {
        // Buscamos la variable en la tabla de variables del bloque actual
        return varStack.peek().containsKey(name);
    }

    // get Iterator
    public GrapeSymbol[] getSymbols() {
        return varTable.values().toArray(new GrapeSymbol[0]);
    }

    // Funciones

    public boolean hasFunctions() {
        return !functionStack.isEmpty();
    }

    public void addFunction(FunctionSymbol function) {
        if (!isSymbolUsed(function.getName())) {
            funcTable.put(function.getName(), function);
        }
    }

    public void enterFunction(FunctionSymbol function) {
        functionStack.push(function);

        // Añadimos un nuevo bloque clon del anterior
        varStack.push(new HashMap<>(varStack.peek()));

    }

    public FunctionSymbol popFunction() {
        // Sacamos la tabla de variables de ese bloque
        varStack.pop();
        // Sacamos la funcion
        return functionStack.pop();
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
        if (varStack.peek().containsKey(symbol)) {
            throw new RuntimeException("Variable " + symbol + " already exists");
        }

        // Comprovar si ya existe la funcion
        if (funcTable.containsKey(symbol)) {
            throw new RuntimeException("Function " + symbol + " already exists");
        }

        return false;
    }

}
