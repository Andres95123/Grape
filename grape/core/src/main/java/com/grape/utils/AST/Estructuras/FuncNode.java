package com.grape.utils.AST.Estructuras;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.AST.Node;

public class FuncNode extends EstructuraControl {

    private FunctionSymbol functionSym;
    private BloqueComando body;

    public FuncNode(FunctionSymbol funcSym, BloqueComando body) {
        this.functionSym = funcSym;
        this.body = body;
    }

    public FunctionSymbol getFunctionSym() {
        return functionSym;
    }

    public String getName() {
        return functionSym.getName();
    }

    public BloqueComando getBody() {
        return body;
    }

    public UnderlyingSymbolType getReturnType() {
        return functionSym.getReturnType();
    }

    public Node[] getParameters() {
        return (Node[]) functionSym.getParameters();
    }

}
