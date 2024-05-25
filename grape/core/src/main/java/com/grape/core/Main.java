package com.grape.core;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;

import com.grape.cup.Parser;
import com.grape.jflex.Scanner;
import com.grape.utils.ASTAnalyzer;
import com.grape.utils.IRGenerator;
import com.grape.utils.AST.*;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;

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
            ProgramNode raiz = (ProgramNode) parser.parse().value;

            // Analizamos el AST
            new ASTAnalyzer(raiz);

            List<String> irCode = IRGenerator.generateIR(raiz);
            for (String statement : irCode) {
                System.out.println(statement);
            }

        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }
    }

}
