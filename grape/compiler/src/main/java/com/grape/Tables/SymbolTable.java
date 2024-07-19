package com.grape.Tables;

import java.util.HashMap;
import java.util.Stack;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;

import java_cup.sym;

public class SymbolTable {

    private int blockCounter = 0;

    HashMap<String, GrapeSymbol> varTable;
    HashMap<String, FunctionSymbol> funcTable;

    Stack<FunctionSymbol> functionStack;
    Stack<HashMap<String, GrapeSymbol>> varStack;

    public SymbolTable() {
        varTable = new HashMap<>();
        varStack = new Stack<>();
        varStack.push(new HashMap<>(varTable));

        funcTable = new HashMap<>();
        functionStack = new Stack<>();
    }

    public void addVariable(GrapeSymbol symbol) {

        if (!isSymbolUsed(symbol.getName())) {

            // Añadimos la variable a la tabla de variables (todos los simbolos)
            varTable.put(symbol.getName(), symbol);

            // Añadimos la variable a la tabla de variables del bloque actual
            varStack.peek().put(symbol.getName(), symbol);

        }

    }

    public void enterBlock() {
        blockCounter++;
        varStack.push(new HashMap<>(varStack.peek()));
    }

    public void exitBlock() {
        varStack.pop();
    }

    public GrapeSymbol getVariable(String name) {

        if (!containsSymbol(name)) {
            throw new RuntimeException("Variable " + name + " not found");
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

    }

    public FunctionSymbol peekFunction() {
        // Devolvemos la funcion
        return functionStack.peek();
    }

    public FunctionSymbol popFunction() {
        // Sacamos la funcion
        return functionStack.pop();
    }

    public FunctionSymbol getFunction(String name) {

        if (!containsFunction(name)) {
            throw new RuntimeException("Function " + name + " not found");
        }

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
