package com.grape.utils.AST.Comandos;

import com.grape.utils.AST.Node;
import com.grape.utils.AST.Node;

public class ReturnFuncNode extends Comando {

    Node Node;

    public ReturnFuncNode(Node Node) {
        this.Node = Node;
    }

    public Node getNode() {
        return Node;
    }

}
