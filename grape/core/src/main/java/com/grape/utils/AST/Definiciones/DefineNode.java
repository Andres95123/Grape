package com.grape.utils.AST.Definiciones;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Node;

public abstract class DefineNode extends Node {

    abstract public Tipo getType();

    abstract public boolean isType(Tipo type);

}
