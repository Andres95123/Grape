package com.grape.utils;

import java.util.ArrayList;
import java.util.List;

import com.grape.Compiler.Compiler;
import com.grape.Symbols.Libreria;
import com.grape.Tables.SymbolTable;
import com.grape.cup.Parser;
import com.grape.jflex.Scanner;
import com.grape.utils.AST.Base.ImportNode;
import com.grape.utils.AST.Estructuras.EstructuraControl;
import com.grape.utils.AST.Estructuras.RootNode;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

public class ImportManager {

    public static List<Libreria> librerias;

    public static EstructuraControl[] searchImports(EstructuraControl[] node) throws Exception {

        librerias = new ArrayList<>();

        // Buscamos los imports y los añadimos a la lista de librerias
        // Los eliminamos del array de nodos
        List<EstructuraControl> newNodes = new ArrayList<>();
        for (EstructuraControl n : node) {
            if (n instanceof ImportNode) {
                ImportNode imp = (ImportNode) n;
                librerias.add(new Libreria(imp.getNombre()));
            } else {
                newNodes.add(n);
            }
        }

        // Creamos el folder output
        new java.io.File("output").mkdir();

        // Creamos un parser y un lexer para cada libreria y añadimos los nodos
        // al array de nodos

        // Guardamos la tabla de simbolos original
        // SymbolTable originalSymTable = ASTExplorer.symTable;

        for (Libreria lib : librerias) {
            // ASTExplorer.symTable = new SymbolTable();
            Scanner scanner = new Scanner(lib.getLibContent());

            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(scanner, sf);

            // Parseamos el archivo y lo guardamos
            Symbol parseado = parser.parse();
            // Controlamos errores

            if (parser.hasError()) {
                throw new RuntimeException("Error : error de compilacion en libreria " + lib.getNombre());
            }

            RootNode root = (RootNode) parseado.value;

            ASTExplorer.explore(root.getEstructuras());

        }

        return newNodes.toArray(new EstructuraControl[0]);

    }

}
