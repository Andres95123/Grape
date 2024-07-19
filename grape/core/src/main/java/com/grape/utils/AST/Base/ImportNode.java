package com.grape.utils.AST.Base;

import com.grape.utils.AST.Estructuras.EstructuraControl;

public class ImportNode extends EstructuraControl {

    private String nombre;

    public ImportNode(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
