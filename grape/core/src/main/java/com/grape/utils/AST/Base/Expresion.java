package com.grape.utils.AST.Base;

import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.AST.Node;

public abstract class Expresion extends Node {

    public abstract UnderlyingSymbolType getTipo();

}
