package com.grape.utils.AST;

import com.grape.utils.Tipo;

public abstract class Node {

    public abstract boolean isType(Tipo type);

    public abstract Tipo getType();

    public abstract String getCode();

}
