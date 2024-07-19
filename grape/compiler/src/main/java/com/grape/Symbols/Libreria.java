package com.grape.Symbols;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.tools.ant.taskdefs.Input;

public class Libreria {

    private static final String LIB_PATH = "librerias/";
    private String nombre;

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public FileReader getLibContent() throws IOException {

        InputStream inputStream = Libreria.class.getClassLoader().getResourceAsStream("libs/mathLib.lib");

        if (inputStream == null) {
            System.out.println("No existe esa libreria");
            return null;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        // Guardamos el contenido de la libreria en un archivo temporal
        // para poder pasarlo al parser
        File temp = File.createTempFile("temp_lib_" + nombre, ".tmp");

        // Escribimos el contenido de la libreria en el archivo temporal
        // para poder pasarlo al parser
        FileWriter writer = new FileWriter(temp);
        writer.write(stringBuilder.toString());
        writer.close();

        // Devuelve un FileReader al archivo temporal

        return new FileReader(temp);
    }
}
