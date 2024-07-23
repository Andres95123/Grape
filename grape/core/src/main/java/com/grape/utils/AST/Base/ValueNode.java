package com.grape.utils.AST.Base;

import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.utils.ValueContainer;
import com.grape.utils.AST.Node;

public class ValueNode extends Expresion {

    private Object value;
    private UnderlyingSymbolType tipo;

    public ValueNode(ValueContainer value) {
        this.value = value.getValue();
        this.tipo = value.getType();
    }

    public String getValue() {

        switch (tipo) {
            case INT:
                return value + "";
            case FLOAT:
                return value + "";
            case CHAR:
                return "'" + (char) value + "'";
            case BOOL:
                return (boolean) value ? "-1" : "0";
            case STRING:
                return value.toString();
        }

        throw new RuntimeException("Tipo no soportado");
    }

    @Override
    public UnderlyingSymbolType getTipo() {
        return tipo;
    }

}
