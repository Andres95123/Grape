package com.grape.utils.AST.Estructuras;

import java.util.Stack;

import com.grape.utils.AST.Node;

public class RootNode extends Node {

    private EstructuraControl[] estructuras;

    public RootNode(EstructuraControl[] e) {
        estructuras = e;
    }

    public EstructuraControl[] getEstructuras() {
        return estructuras;
    }

}
