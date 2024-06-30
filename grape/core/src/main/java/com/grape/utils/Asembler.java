package com.grape.utils;

import java.util.Stack;

import com.grape.utils.AST.*;
import com.grape.utils.AST.Comandos.*;
import com.grape.utils.AST.Definiciones.*;

public class Asembler {

    public static void asembler(Stack<IntermedianCode> stack) {

        String asembler = "";

        // Recorremos el stack de código intermedio
        while (!stack.isEmpty()) {
            asembler += asembler(stack.pop()) + "\n";
        }

        // Escribimos el código asembler en un archivo

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter("output.asm");
            myWriter.write(asembler);
            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static String asembler(IntermedianCode codigoInt) {

        // Ensamblamos a x86

        switch (codigoInt.getComando()) {
            case ASSIGN:
                return "mov " + codigoInt.getArg1() + ", " + codigoInt.getResult();
            case ADD:
                return "add " + codigoInt.getArg1() + ", " + codigoInt.getArg2() + ", " + codigoInt.getResult();
            case SUB:
                return "sub " + codigoInt.getArg1() + ", " + codigoInt.getArg2() + ", " + codigoInt.getResult();
            case MUL:
                return "mul " + codigoInt.getArg1() + ", " + codigoInt.getArg2() + ", " + codigoInt.getResult();
            case DIV:
                return "div " + codigoInt.getArg1() + ", " + codigoInt.getArg2() + ", " + codigoInt.getResult();
            case MOD:
                return "mod " + codigoInt.getArg1() + ", " + codigoInt.getArg2() + ", " + codigoInt.getResult();
            default:
                return "";
        }

    }

}
