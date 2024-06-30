package com.grape.utils.AST.Comandos;

import com.grape.utils.Tipo;
import com.grape.utils.AST.Node;
import com.grape.utils.AST.Definiciones.ExpresionNode;

public class IfNode extends Node {

    ExpresionNode condition;
    Node ifBody;
    Node elseBody;

    // Constructor If-Else
    public IfNode(Node condition, Node ifBody, Node elseBody) {
        this.condition = (ExpresionNode) condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    // Constructor If
    public IfNode(Node condition, Node ifBody) {
        this.condition = (ExpresionNode) condition;
        this.ifBody = ifBody;
        this.elseBody = null;
    }

    public ExpresionNode getCondition() {
        return condition;
    }

    public Node getIfBody() {
        return ifBody;
    }

    public Node getElseBody() {
        return elseBody;
    }

}
