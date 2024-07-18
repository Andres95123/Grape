package com.grape.utils.AST;

import com.grape.Symbols.UnderlyingSymbolType;

public abstract class ReturnNode extends Node {

    private UnderlyingSymbolType type;

    abstract public UnderlyingSymbolType getTipo();

}
