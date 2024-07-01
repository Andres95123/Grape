package com.grape.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import com.grape.utils.AST.Definiciones.VariableNode;

public class Asembler {

    public static void asembler(Stack<IntermedianCode> stack) throws IOException {

        String asembler = "";
        FileWriter output = new FileWriter("output.asm");

        // Escribimos el encabezado del archivo asembler
        encabezado(output);

        // Recorremos el stack de código intermedio
        while (!stack.isEmpty()) {
            asembler += asembler(stack.pop()) + "\n";
        }

        // Escribimos el código asembler en un archivo

        output.write(asembler);
        output.write("\tmov eax, 1\n");
        output.write("\tint 0x80");
        output.close();

    }

    private static void encabezado(FileWriter output) {

        // Escribimos el encabezado del archivo asembler
        try {
            output.write("section .data\n");

            // Variables
            while (!ASTExplorer.variables.isEmpty()) {
                output.write("\t" + ASTExplorer.variables.pop().toString() + "\n");
            }

            output.write("section .bss\n");

            for (int i = 0; i < ASTExplorer.numTmpVar; i++) {
                output.write("\tT" + i + " resd 1\n");
            }

            output.write("section .text\n");
            output.write("global _start\n");
            output.write("_start:\n");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static String asembler(IntermedianCode codigoInt) {

        String comando = "";
        // Ensamblamos a x86

        switch (codigoInt.getComando()) {
            case ASSIGN:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            case ADD:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tadd eax," + codigoInt.getArg2() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            case SUB:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tsub eax," + codigoInt.getArg2() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            case MUL:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\timul eax," + codigoInt.getArg2() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            case DIV:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tcdq\n";
                comando += "\tidiv " + codigoInt.getArg2() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            case MOD:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tcdq\n";
                comando += "\tidiv " + codigoInt.getArg2() + "\n";
                comando += "\tmov [" + codigoInt.getResult() + "], edx";
                return comando;
            case POW:
                comando += "\tmov eax," + codigoInt.getArg1() + "\n";
                comando += "\tmov ecx," + codigoInt.getArg2() + "\n";
                comando += "\tpow eax, ecx\n";
                comando += "\tmov [" + codigoInt.getResult() + "], eax";
                return comando;
            default:
                return "";
        }

    }

}
