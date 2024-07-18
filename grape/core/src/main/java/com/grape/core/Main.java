package com.grape.core;

import java.io.Reader;
import java.util.Stack;
import java.io.FileReader;

import com.grape.cup.Parser;
import com.grape.jflex.Scanner;
import com.grape.utils.ASTExplorer;
import com.grape.utils.AST.*;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

import com.grape.Compiler.*;
import com.grape.Tables.SymbolTable;

public class Main {

    public static void main(String[] args) {
        Reader input = null;

        // Borramos el archivo de salida
        try {
            new java.io.File("output.txt").delete();
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }

        try {
            if (args.length > 0) {
                input = new FileReader(args[0]);
            } else {
                System.out.println("Introduce el nombre del archivo a compilar");
                input = new FileReader(
                        "c:\\Users\\andre\\OneDrive - Universitat de les Illes Balears\\APPS\\GIT\\Grape\\grape\\core\\src\\main\\java\\com\\grape\\data\\test.txt");
            }

            Scanner scanner = new Scanner(input);

            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(scanner, sf);

            long start = System.nanoTime();

            // Parseamos el archivo y lo guardamos
            Symbol parseado = parser.parse();

            System.out.println("Parseado correctamente : en " + (System.nanoTime() - start) / Math.pow(10, 9) + " s\n");

            // Controlamos errores

            if (parser.hasError()) {
                System.out.println("Error : error de compilacion");
                return;
            }

            BlockNode root = (BlockNode) parseado.value;
            SymbolTable st = parser.symTable;

            ASTExplorer.explore(root, st);

            Compiler.compile(st, ASTExplorer.allCode, "output.asm");

        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }
    }

}
