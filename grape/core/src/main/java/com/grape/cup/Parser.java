
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.grape.cup;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.*;
import java.io.*;
import com.grape.utils.*;
import java.util.Stack;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\017\000\002\002\004\000\002\012\002\000\002\002" +
    "\004\000\002\004\004\000\002\004\002\000\002\005\003" +
    "\000\002\005\003\000\002\006\011\000\002\007\007\000" +
    "\002\011\003\000\002\011\005\000\002\011\005\000\002" +
    "\011\005\000\002\011\005\000\002\011\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\040\000\010\002\000\010\000\011\000\001\002\000" +
    "\004\002\042\001\002\000\010\002\ufffd\010\010\011\012" +
    "\001\002\000\010\002\ufffb\010\ufffb\011\ufffb\001\002\000" +
    "\010\002\ufffc\010\ufffc\011\ufffc\001\002\000\004\005\034" +
    "\001\002\000\004\002\uffff\001\002\000\004\005\015\001" +
    "\002\000\010\002\ufffd\010\010\011\012\001\002\000\004" +
    "\002\ufffe\001\002\000\004\017\016\001\002\000\004\004" +
    "\020\001\002\000\016\012\023\013\024\014\022\015\026" +
    "\016\021\020\025\001\002\000\016\012\ufff8\013\ufff8\014" +
    "\ufff8\015\ufff8\016\ufff8\020\ufff8\001\002\000\004\004\020" +
    "\001\002\000\004\004\020\001\002\000\004\004\020\001" +
    "\002\000\004\004\020\001\002\000\010\002\ufff9\010\ufff9" +
    "\011\ufff9\001\002\000\004\004\020\001\002\000\016\012" +
    "\ufff4\013\ufff4\014\ufff4\015\ufff4\016\ufff4\020\ufff4\001\002" +
    "\000\016\012\ufff6\013\ufff6\014\022\015\026\016\021\020" +
    "\ufff6\001\002\000\016\012\ufff7\013\ufff7\014\022\015\026" +
    "\016\021\020\ufff7\001\002\000\016\012\ufff5\013\ufff5\014" +
    "\ufff5\015\ufff5\016\ufff5\020\ufff5\001\002\000\016\012\ufff3" +
    "\013\ufff3\014\ufff3\015\ufff3\016\ufff3\020\ufff3\001\002\000" +
    "\004\007\035\001\002\000\004\006\036\001\002\000\004" +
    "\017\037\001\002\000\004\004\020\001\002\000\016\012" +
    "\023\013\024\014\022\015\026\016\021\020\041\001\002" +
    "\000\010\002\ufffa\010\ufffa\011\ufffa\001\002\000\004\002" +
    "\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\040\000\006\002\003\012\004\001\001\000\002\001" +
    "\001\000\012\004\010\005\012\006\006\007\005\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\012\004\013\005\012" +
    "\006\006\007\005\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\011\032\001\001\000\004\011\031\001" +
    "\001\000\004\011\030\001\001\000\004\011\027\001\001" +
    "\000\002\001\001\000\004\011\026\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\011\037\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




/***
    private Scanner scanner;
    public Parser(Scanner scanner) { 
        this.scanner = scanner;
    }
***/
  
  // Estructuras de datos para almacenar los errores

  Stack<Bloque> pilaBloques = new Stack<>();



  /**********************************************************************
   * sobrecàrrega de mètodes per gestionar els errors que es localitzin *
   **********************************************************************/

  @Override
  public void unrecovered_syntax_error(Symbol cur_token) throws Exception {
    report_error("Error de sintaxis catastrofico", cur_token);
    done_parsing();    
  }

  @Override
  public void syntax_error(Symbol cur_token) {
    report_error("de sintaxis", cur_token);
  }

  @Override
  public void report_error(String message, Object info) {
    StringBuilder msg = new StringBuilder("ERROR");
    if (info instanceof Symbol) {
      ComplexSymbol token = (ComplexSymbol)info;
      Location l = token.getLeft();
      
      if (l != null) {
        msg.append(" (fila: ")
          .append(l.getLine())
          .append(", columna: ")
          .append(l.getColumn())
          .append(")");
      }
    }
    msg.append(": ").append(message);
    
    System.err.println(msg);
  }

  @Override
  public void report_fatal_error(String message, Object info) throws Exception {
    report_error("Error catastrofico irrecuperable ("+message+")", info);
    done_parsing();
  }




/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= CODESTART EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // NT$0 ::= 
            {
              Object RESULT =null;
 pilaBloques.push(new Bloque()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("NT$0",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // CODESTART ::= NT$0 COMANDOS 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 for(Bloque bloque : pilaBloques){
  System.out.println(bloque.toString());
} 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("CODESTART",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // COMANDOS ::= VARIABLE_DEFINITION COMANDOS 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMANDOS",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // COMANDOS ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMANDOS",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // VARIABLE_DEFINITION ::= VAR_DEFINITION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("VARIABLE_DEFINITION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // VARIABLE_DEFINITION ::= INFER_DEFINITION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("VARIABLE_DEFINITION",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // VAR_DEFINITION ::= VAR_INVOKER ID DETERMINE VAR_TYPE ASSIGN EXPRESION Endline 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int tipeleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int tiperight = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		Tipo tipe = (Tipo)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		ValueContainer val = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		

  if (!val.isType(tipe)){
    report_fatal_error (name + " no es de tipo " + val.getType(), val);
  }

 pilaBloques.peek().addVar(name,tipe,val.getValue()); 


              CUP$Parser$result = parser.getSymbolFactory().newSymbol("VAR_DEFINITION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // INFER_DEFINITION ::= INFER_INVOKER ID ASSIGN EXPRESION Endline 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		ValueContainer val = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		

  pilaBloques.peek().addVar(name,val.getType(),val.getValue());


              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INFER_DEFINITION",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESION ::= VALUE 
            {
              ValueContainer RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer val = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = val; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESION ::= EXPRESION PLUS EXPRESION 
            {
              ValueContainer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ValueContainer e1 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer e2 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1.sumar(e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESION ::= EXPRESION MINUS EXPRESION 
            {
              ValueContainer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ValueContainer e1 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer e2 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1.restar(e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESION ::= EXPRESION MULT EXPRESION 
            {
              ValueContainer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ValueContainer e1 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer e2 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1.multiplicar(e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESION ::= EXPRESION DIV EXPRESION 
            {
              ValueContainer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ValueContainer e1 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer e2 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1.dividir(e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESION ::= EXPRESION MOD EXPRESION 
            {
              ValueContainer RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ValueContainer e1 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ValueContainer e2 = (ValueContainer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1.modulo(e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
