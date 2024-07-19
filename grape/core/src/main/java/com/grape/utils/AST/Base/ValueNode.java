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

        Double d = (Double) value;

        switch (tipo) {
            case INT:

                return d.intValue() + "";

            case FLOAT:

                return "_float64(" + d + ")";

            case CHAR:
                return "'" + (char) d.intValue() + "'";
            case BOOL:
                return d.intValue() == 1 ? "-1" : "0";
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
