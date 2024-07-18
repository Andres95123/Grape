package com.grape.Compiler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.grape.IntermedianCode.IntermedianCode;
import com.grape.Symbols.FunctionSymbol;
import com.grape.Symbols.GrapeSymbol;
import com.grape.Symbols.UnderlyingSymbolType;
import com.grape.Tables.SymbolTable;

public class Compiler {

    static StringBuilder bssSection;
    static StringBuilder textSection;
    static StringBuilder functionsSection;

    static StringBuilder outputBuilder;

    public static void compile(SymbolTable symTable, List<IntermedianCode> codes, String output_path)
            throws IOException {

        // Instanciar zona datos
        bssSection = new StringBuilder();
        textSection = new StringBuilder();
        functionsSection = new StringBuilder();

        // Generar datos
        generarDatos(symTable);

        // Obtener codigo maquina

        generarCodigo(codes);

        // Añadir funciones
        for (FunctionSymbol function : symTable.getFunctions()) {
            functionsSection.append(function.getName() + ":\n");

            // Añadir codigo de la funcion
            for (IntermedianCode code : function.getIntermedianCode()) {
                assembleCode(code, functionsSection);
            }

        }

        // Instanciar zona texto
        outputBuilder = new StringBuilder();

        // Generar codigo
        outputBuilder.append("section .bss\n");
        outputBuilder.append(bssSection.toString());
        outputBuilder.append("\nsection .text\n");
        outputBuilder.append("global _start\n");
        outputBuilder.append("_start:\n");
        outputBuilder.append(textSection.toString());

        // Añadimos las funciones
        outputBuilder.append(functionsSection.toString());

        // Escribir en archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(output_path));
        writer.write(outputBuilder.toString());
        writer.close();
    }

    private static void generarCodigo(List<IntermedianCode> codes) {

        for (IntermedianCode code : codes) {
            assembleCode(code, textSection);
        }

        // Finalizar programa con etiqueta _stop_exit
        textSection.append("_stop_exit:\n");
        textSection.append("\tmov rax, 60\n");
        textSection.append("\tmov rdi, 0\n");
        textSection.append("\tsyscall\n");

    }

    private static void assembleCode(IntermedianCode code, StringBuilder textSection) {

        // Añadir comentario
        textSection.append(
                "\t; " + code.getArg1() + " " + code.getCode() + " " + code.getArg2() + " -> "
                        + code.getResult() + "\n");

        switch (code.getCode()) {
            case ADD:
                // Suma dos valores :
                // arg1 + arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax + rbx, arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tadd rax, rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case SUB:
                // Resta dos valores :
                // arg1 - arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax - rbx , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tsub rax, rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case MUL:
                // Multiplica dos valores :
                // arg1 * arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax * rbx , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\timul rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case DIV: // NO COMPROBADO
                // Divide dos valores :
                // arg1 / arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax / rbx , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tidiv rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case MOD: // NO COMPROBADO A PARTIR DE AQUI
                // Modulo de dos valores :
                // arg1 % arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax % rbx , arg3 = rdx
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tidiv rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rdx\n");
                break;

            case AND:
                // Operacion AND de dos valores :
                // arg1 && arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax && rbx , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tand rax, rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case OR:
                // Operacion OR de dos valores :
                // arg1 || arg2 -> result
                // rax = arg1, rbx = arg2, rax = rax || rbx , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tor rax, rbx\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case NOT:
                // Operacion NOT de un valor :
                // !arg1 -> result
                // rax = arg1, rax = !rax , arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tnot rax\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            // Relacionales

            case EQ:
                // Operacion == de dos valores :
                // arg1 == arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si son iguales, devuelve 1, si no, 0
                textSection.append("\tsete al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

                break;

            case NE:

                // Operacion != de dos valores :
                // arg1 != arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si son distintos, devuelve 1, si no, 0
                textSection.append("\tsetne al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

                break;

            case GT:

                // Operacion > de dos valores :
                // arg1 > arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si arg1 > arg2, devuelve 1, si no, 0
                textSection.append("\tsetg al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

                break;

            case LT:

                // Operacion < de dos valores :
                // arg1 < arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si arg1 < arg2, devuelve 1, si no, 0
                textSection.append("\tsetl al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

                break;

            case GE:

                // Operacion >= de dos valores :
                // arg1 >= arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si arg1 >= arg2, devuelve 1, si no, 0
                textSection.append("\tsetge al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

                break;

            case LE:

                // Operacion <= de dos valores :
                // arg1 <= arg2 -> resultado:valor

                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");

                // Si arg1 <= arg2, devuelve 1, si no, 0
                textSection.append("\tsetle al\n");
                textSection.append("\tmovzx rax, al\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");

            case JEQ:

                // Salto si son iguales
                // arg1 == arg2 -> result
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");
                textSection.append("\tje " + code.getResult() + "\n");

                break;

            case JNE:

                // Salto si son distintos
                // arg1 != arg2 -> result
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tcmp rax, rbx\n");
                textSection.append("\tjne " + code.getResult() + "\n");

                break;

            // Asignacion

            case ASSIGN:
                // Asignacion de un valor a una variable :
                // arg1 -> result
                // rax = arg1, arg3 = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                break;

            case ASSIGN_INDEX:
                // Asignacion de un valor a una posicion de un array :
                // arg1 -> result[arg2]
                // rax = arg1, rbx = arg2, result[rbx] = rax
                textSection.append("\tmov rax, " + code.getArg1() + "\n");
                textSection.append("\tmov rbx, " + code.getArg2() + "\n");
                textSection.append("\tmov " + code.getResult() + "[rbx], rax\n");

                break;

            case INCREMENT:
                // Incremento de un valor :
                // result++ -> result
                textSection.append("\tinc dword " + code.getResult() + "\n");
                break;

            case DECREMENT:
                // Decremento de un valor :
                // result-- -> result
                textSection.append("\tdec dword" + code.getResult() + "\n");
                break;

            // Etiquetas
            case LABEL:
                // Etiqueta de un salto
                // result:
                textSection.append(code.getResult() + ":\n");
                break;

            case JMP:
                // Salto a una etiqueta
                // jmp result
                textSection.append("\tjmp " + code.getResult() + "\n");
                break;

            // Funciones
            case CALL:
                // Llamada a una funcion
                // call result
                textSection.append("\tcall " + code.getResult() + "\n");
                break;

            case RETURN:
                // Retorno de una funcion
                // return arg1
                // rax = arg1, ret
                textSection.append("\tmov " + code.getResult() + ", rax\n");
                textSection.append("\tret\n");
                break;
            // Debugging
            case PRINT:
                // Imprimir un valor
                // print arg1
                // rax = arg1, printf(rax)
                textSection.append("\tmov rdi, 1\n");
                textSection.append("\tmov rsi, " + code.getResult() + "\n");
                textSection.append("\tmov rdx, 4\n");
                textSection.append("\tmov rax, 1\n");
                textSection.append("\tsyscall\n");

            default:
                break;
        }

    }

    private static void generarDatos(SymbolTable symTable) {

        GrapeSymbol[] symbols = symTable.getSymbols();

        for (GrapeSymbol symbol : symbols) {

            if (symbol.getScope() == 1) { // Es Global / Publico
                bssSection.append("global " + symbol.getName() + "\n");
            }

            switch (symbol.getType()) {
                case ARRAY: // Array y Variables
                    bssSection.append(
                            symbol.getName() + " " + UnderlyingSymbolType.toAsemblyOperation(symbol.getSubtype(), false)
                                    + " " + symbol.getSize() + "\n");
                    break;

                case STRUCT: // Struct
                    // TODO: Implementar

                    break;

                case FUNCTION: // Funciones
                    // TODO: Implementar

                default:
                    break;
            }

        }

    }

}
