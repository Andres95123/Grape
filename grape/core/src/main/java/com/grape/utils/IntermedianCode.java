package com.grape.utils;

import com.grape.utils.AST.Comandos.Comandos;

public class IntermedianCode {

    private Comandos comando;
    private String arg1;
    private String arg2;
    private String result;

    public IntermedianCode(Comandos comando, String arg1, String arg2, String result) {
        this.comando = comando;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    @Override
    public String toString() {
        return comando + " " + arg1 + " " + arg2 + " " + result;
    }

    public Comandos getComando() {
        return comando;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public String getResult() {
        return result;
    }
}
