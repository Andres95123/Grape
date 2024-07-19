package com.grape.utils.AST.Comandos;

public class AddressNode extends Comando {

    private String symbol;

    public AddressNode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
