package com.grape.core;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.io.FileReader;

import com.grape.cup.Parser;
import com.grape.jflex.Scanner;
import com.grape.utils.ASTExplorer;
import com.grape.utils.Asembler;
import com.grape.utils.IntermedianCode;
import com.grape.utils.Tipo;
import com.grape.utils.AST.*;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
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

            long start = System.nanoTime();

            // Parseamos el archivo y lo guardamos
            Symbol parseado = parser.parse();

            System.out.println("Parseado correctamente : en " + (System.nanoTime() - start) / Math.pow(10, 9) + " s\n");

            // Controlamos errores

            if (parser.hasError()) {
                System.out.println("Error : error de compilacion");
                return;
            }

            ProgramNode root = (ProgramNode) parseado.value;

            // Exploramos el AST (optimizaciones y comprovaciones)
            start = System.nanoTime();
            Stack<IntermedianCode> stack = ASTExplorer.explore(root);
            System.out
                    .println("Explorado correctamente : en " + (System.nanoTime() - start) / Math.pow(10, 9) + " s\n");

            // Generamos el código asembler
            start = System.nanoTime();
            Asembler.asembler(stack);
            System.out.println("Generado correctamente : en " + (System.nanoTime() - start) / Math.pow(10, 9) + " s\n");

        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }
    }

}
