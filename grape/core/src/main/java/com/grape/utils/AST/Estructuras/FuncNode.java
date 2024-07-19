package com.grape.utils.AST.Estructuras;

import java.util.ArrayDeque;

import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.AST.Base.VarNode;

public class FuncNode extends EstructuraControl {

    private FunctionSymbol functionSym;
    private EstructuraControl[] body;

    public FuncNode(FunctionSymbol funcSym, ArrayDeque<EstructuraControl> body) {
        this.functionSym = funcSym;
        this.body = body.toArray(new EstructuraControl[0]);
    }

    public FunctionSymbol getFunctionSym() {
        return functionSym;
    }

    public String getName() {
        return functionSym.getName();
    }

    public EstructuraControl[] getBody() {
        return body;
    }

    public UnderlyingSymbolType getReturnType() {
        return functionSym.getReturnType();
    }

    public VarNode[] getParameters() {
        return (VarNode[]) functionSym.getParameters();
    }

}
