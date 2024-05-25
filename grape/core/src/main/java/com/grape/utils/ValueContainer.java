package com.grape.utils;

public class ValueContainer {
    Object value;
    Tipo type;

    public ValueContainer(Object value, Tipo type) {
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public Tipo getType() {
        return type;
    }

    public boolean isType(Tipo type) {
        return this.type == type;
    }

    public ValueContainer sumar(ValueContainer vc) {
        if (this.type == Tipo.INT && vc.type == Tipo.INT) {
            this.value = (double) this.value + (double) vc.value;
        } else if (this.type == Tipo.STRING && vc.type == Tipo.STRING) {
            this.value = (String) this.value + (String) vc.value;
        }
        return this;
    }

    public ValueContainer restar(ValueContainer vc) {
        if (this.type == Tipo.INT && vc.type == Tipo.INT) {
            this.value = (double) this.value - (double) vc.value;
        }
        return this;
    }

    public ValueContainer multiplicar(ValueContainer vc) {
        if (this.type == Tipo.INT && vc.type == Tipo.INT) {
            this.value = (double) this.value * (double) vc.value;
        }
        return this;
    }

    public ValueContainer dividir(ValueContainer vc) {
        if (this.type == Tipo.INT && vc.type == Tipo.INT) {
            this.value = (double) this.value / (double) vc.value;
        }
        return this;
    }

    public ValueContainer modulo(ValueContainer vc) {
        if (this.type == Tipo.INT && vc.type == Tipo.INT) {
            this.value = (double) this.value % (double) vc.value;
        }
        return this;
    }
}
