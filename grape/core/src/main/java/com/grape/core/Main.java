package com.grape.core;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileReader;

import com.grape.cup.Parser;
import com.grape.jflex.Scanner;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;

public class Main {

    public static void main(String[] args) {
        Reader input = null;

        try {
            if (args.length > 0) {
                input = new FileReader(args[0]);
            } else {
                System.out.println("Introduce el nombre del archivo a compilar");

                // input = new InputStreamReader(System.in);
                input = new FileReader("c:\\Users\\andre\\OneDrive - Universitat de les Illes Balears\\APPS\\GIT\\Grape\\grape\\core\\src\\main\\java\\com\\grape\\data\\test.txt");
            }

            Scanner scanner = new Scanner(input);

            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(scanner, sf);
            parser.parse();
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace(System.err);
        }
    }
}
