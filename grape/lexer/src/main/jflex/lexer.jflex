package com.grape.jflex;

import com.grape.cup.*;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

import java.io.*;
import com.grape.utils.*;

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
   return symbol(ParserSym.EOF);
%eofval}
    
//Declaración de tokens especiales

ws = [' '|'\t'|'\r'|'\n'|"\r\n"]+
endline = ";"

//Declaración de tokens
number = [0-9]+

// Definición usando tokens
string_symbol = \"
character = \\ [^]
string = {string_symbol} [^\"]* {string_symbol}

decimal = (\-)?{number}("."{number})?
id = [a-zA-Z][a-zA-Z0-9]*


boolean_positive = "true"
boolean_negative = "false"


// Operaciones
    // Aritmeticas
    plus = "+"
    minus = "-"
    mult = "*"
    div = "/"
    mod = "%"
    assign = "="
    open_bracket = "("
    close_bracket = ")"
// Relacionales
    equal = "=="
    different = "!="
    greater = ">"
    less = "<"
    greater_equal = ">="
    less_equal = "<="

determine = ":"

// Operadores lógicos
    and = "&&"
    or = "||"
    not = "!"

//Tipos de tokens
integer_type = "int"
boolean_type = "bool"
char_type = "char"
string_type = "string"

// Textos necesarios
var = "var"
infer = "infer"
if = "if"
then = "then"
else = "else"
endif = "endif"
endfor = "endfor"
for = "for"


%{

    /**
     Construcció d'un symbol sense atribut associat.
     **/
    private ComplexSymbol symbol(int type) {
        // Sumar 1 per a que la primera línia i columna no sigui 0.
        Location esquerra = new Location(yyline+1, yycolumn+1);
        Location dreta = new Location(yyline+1, yycolumn+yytext().length()+1);
        
        saveSymbol(type);

        return new ComplexSymbol(ParserSym.terminalNames[type], type, esquerra, dreta);
    }

    /**
     Construcció d'un symbol amb un atribut associat.
     **/
    private Symbol symbol(int type, Object value, Tipo tipoReal) {
        // Sumar 1 per a que la primera línia i columna no sigui 0.
        Location esquerra = new Location(yyline+1, yycolumn+1);
        Location dreta = new Location(yyline+1, yycolumn+yytext().length()+1);

        saveSymbol(type);

        return new ComplexSymbol(ParserSym.terminalNames[type], type, esquerra, dreta, new ValueContainer(value,tipoReal));
    }

    private Symbol symbol(int type, Object value) {
        // Sumar 1 per a que la primera línia i columna no sigui 0.
        Location esquerra = new Location(yyline+1, yycolumn+1);
        Location dreta = new Location(yyline+1, yycolumn+yytext().length()+1);

        saveSymbol(type);

        return new ComplexSymbol(ParserSym.terminalNames[type], type, esquerra, dreta, value);
    }


public void saveSymbol(int type) {

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        writer.write("Symbol: " + ParserSym.terminalNames[type] + "\n");
        writer.close();
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo output.txt");
    }
}

%}

%%

// Definición de las reglas de producción

    // Valores
    {decimal} {return symbol(ParserSym.VALUE, Double.parseDouble(yytext()), Tipo.INT);}
    {boolean_positive} {return symbol(ParserSym.VALUE, true, Tipo.BOOL);}
    {boolean_negative} {return symbol(ParserSym.VALUE, false, Tipo.BOOL);}
    {character} {return symbol(ParserSym.VALUE, yytext().charAt(1), Tipo.CHAR);}
    {string} {return symbol(ParserSym.VALUE, yytext().substring(1, yytext().length()-1), Tipo.STRING);}

    // Definicion tipos
    {integer_type} {return symbol(ParserSym.VAR_TYPE, Tipo.INT);}
    {boolean_type} {return symbol(ParserSym.VAR_TYPE, Tipo.BOOL);}
    {char_type} {return symbol(ParserSym.VAR_TYPE, Tipo.CHAR);}
    {string_type} {return symbol(ParserSym.VAR_TYPE, Tipo.STRING);}

    // Operaciones
        // Aritméticas
        {plus} {return symbol(ParserSym.PLUS);}
        {minus} {return symbol(ParserSym.MINUS);}
        {mult} {return symbol(ParserSym.MULT);}
        {div} {return symbol(ParserSym.DIV);}
        {mod} {return symbol(ParserSym.MOD);}
        {assign} {return symbol(ParserSym.ASSIGN);}
        {open_bracket} {return symbol(ParserSym.OBracket);}
        {close_bracket} {return symbol(ParserSym.CBracket);}
        // Relacionales
        {equal} {return symbol(ParserSym.EQ);}
        {different} {return symbol(ParserSym.NEQ);}
        {greater} {return symbol(ParserSym.GT);}
        {less} {return symbol(ParserSym.LT);}
        {greater_equal} {return symbol(ParserSym.GE);}
        {less_equal} {return symbol(ParserSym.LE);}
        // Lógicas
        

    // Especiales
    {determine} {return symbol(ParserSym.DETERMINE);}
    {ws} {}
    {endline} {return symbol(ParserSym.Endline);}

    // Textos
    {var} {return symbol(ParserSym.VAR_INVOKER);}
    {infer} {return symbol(ParserSym.INFER_INVOKER);}
    {if} {return symbol(ParserSym.IF_INVOKER);}
    {then} {return symbol(ParserSym.THEN_INVOKER);}
    {else} {return symbol(ParserSym.ELSE_INVOKER);}
    {endif} {return symbol(ParserSym.ENDIF_INVOKER);}
    {for} {return symbol(ParserSym.FOR_INVOKER);}
    {endfor} {return symbol(ParserSym.ENDFOR_INVOKER);}


    {id} {return symbol(ParserSym.ID, yytext());}

    [^] {return symbol(ParserSym.error);}