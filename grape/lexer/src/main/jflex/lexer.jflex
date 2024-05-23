package com.grape.jflex;

import java.io.*;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%

%standalone

/****
 Indicar que usamos java_cup
 ****/
%cup

%public             
%class Scanner       


//yline / ycolumn y le dices que son caracteres por defecto
%char
%line
%column

//Que devolver al acabar el documento
%eofval{
   saveSymbol("EOF");
%eofval}
    
//Declaración de tokens

comment_line = "//".*;
ws = [ \t\n\r\f]+;
endline = "\n";


%{

    /**
     Construcció d'un symbol sense atribut associat.
     **/
    // private ComplexSymbol symbol(int type) {
    //     // Sumar 1 per a que la primera línia i columna no sigui 0.
    //     Location esquerra = new Location(yyline+1, yycolumn+1);
    //     Location dreta = new Location(yyline+1, yycolumn+yytext().length()+1);
        
    //     saveSymbol(type);

    //     return new ComplexSymbol(ParserSym.terminalNames[type], type, esquerra, dreta);
    // }

    /**
     Construcció d'un symbol amb un atribut associat.
     **/
    // private Symbol symbol(int type, Object value) {
    //     // Sumar 1 per a que la primera línia i columna no sigui 0.
    //     Location esquerra = new Location(yyline+1, yycolumn+1);
    //     Location dreta = new Location(yyline+1, yycolumn+yytext().length()+1);

    //     saveSymbol(type);

    //     // return new ComplexSymbol(ParserSym.terminalNames[type], type, esquerra, dreta, value);
    // }


public void saveSymbol(String type) {

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Lexico_Symbolos.txt", true));
        writer.write("Symbol: " + type + "\n");
        writer.close();
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo LexicoSymbolos.txt");
    }
}

%}

%%

    {comment_line} {saveSymbol( "Comment Line");}
    {ws} {saveSymbol("WS");}
    {endline} {saveSymbol("EndLine");}

    [^] {saveSymbol("ERROR OTHER");}