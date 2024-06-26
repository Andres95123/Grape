// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: lexer/src/main/jflex/lexer.jflex

package com.grape.jflex;

import com.grape.cup.*;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

import java.io.*;
import com.grape.utils.*;


@SuppressWarnings("fallthrough")
public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\2\0\1\1\22\0\1\1\1\2\1\3"+
    "\2\0\1\4\1\0\1\1\1\5\1\6\1\7\1\10"+
    "\1\0\1\11\1\12\1\13\12\14\1\15\1\16\1\17"+
    "\1\20\1\21\2\0\32\22\1\0\1\23\4\0\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\2\22\1\35\1\22\1\36\1\37\2\22\1\40\1\41"+
    "\1\42\1\43\1\44\4\22\1\0\1\1\u0183\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\1\10\20\1\21\1\0\1\22\1\0"+
    "\1\23\1\24\1\25\1\26\6\20\1\27\5\20\1\12"+
    "\5\20\1\30\1\20\1\31\3\20\1\32\1\33\1\34"+
    "\1\35\5\20\1\36\1\37\1\20\1\40\1\41\1\42"+
    "\1\20\1\43\1\44";

  private static int [] zzUnpackAction() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\45\0\112\0\157\0\224\0\45\0\45\0\45"+
    "\0\45\0\45\0\271\0\45\0\336\0\45\0\45\0\u0103"+
    "\0\u0128\0\u014d\0\u0172\0\u0197\0\u01bc\0\u01e1\0\u0206\0\u022b"+
    "\0\u0250\0\u0275\0\u029a\0\u02bf\0\45\0\224\0\45\0\u02e4"+
    "\0\45\0\45\0\45\0\45\0\u0309\0\u032e\0\u0353\0\u0378"+
    "\0\u039d\0\u03c2\0\u0172\0\u03e7\0\u040c\0\u0431\0\u0456\0\u047b"+
    "\0\u02e4\0\u04a0\0\u04c5\0\u04ea\0\u050f\0\u0534\0\u0172\0\u0559"+
    "\0\u0172\0\u057e\0\u05a3\0\u05c8\0\u0172\0\u0172\0\u0172\0\u0172"+
    "\0\u05ed\0\u0612\0\u0637\0\u065c\0\u0681\0\u0172\0\u0172\0\u06a6"+
    "\0\u0172\0\u0172\0\u0172\0\u06cb\0\u0172\0\u0172";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\2\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\23\1\25\1\26\1\23"+
    "\1\27\1\30\2\23\1\31\4\23\1\32\1\33\1\23"+
    "\1\34\46\0\1\3\63\0\1\35\24\0\3\36\1\37"+
    "\41\36\14\0\1\15\42\0\1\40\1\0\1\15\50\0"+
    "\1\41\44\0\1\42\44\0\1\43\40\0\1\23\5\0"+
    "\1\23\1\0\21\23\45\44\14\0\1\23\5\0\1\23"+
    "\1\0\13\23\1\45\5\23\14\0\1\23\5\0\1\23"+
    "\1\0\7\23\1\46\11\23\14\0\1\23\5\0\1\23"+
    "\1\0\11\23\1\47\1\50\6\23\14\0\1\23\5\0"+
    "\1\23\1\0\1\51\12\23\1\52\5\23\14\0\1\23"+
    "\5\0\1\23\1\0\5\23\1\53\4\23\1\54\6\23"+
    "\14\0\1\23\5\0\1\23\1\0\16\23\1\55\2\23"+
    "\14\0\1\23\5\0\1\23\1\0\7\23\1\56\4\23"+
    "\1\57\4\23\14\0\1\23\5\0\1\23\1\0\1\60"+
    "\20\23\14\0\1\61\44\0\1\23\5\0\1\23\1\0"+
    "\13\23\1\62\5\23\14\0\1\23\5\0\1\23\1\0"+
    "\1\63\20\23\14\0\1\23\5\0\1\23\1\0\15\23"+
    "\1\64\3\23\14\0\1\23\5\0\1\23\1\0\3\23"+
    "\1\65\15\23\14\0\1\23\5\0\1\23\1\0\11\23"+
    "\1\66\7\23\14\0\1\23\5\0\1\23\1\0\14\23"+
    "\1\67\4\23\14\0\1\23\5\0\1\23\1\0\5\23"+
    "\1\70\10\23\1\71\2\23\14\0\1\23\5\0\1\23"+
    "\1\0\14\23\1\72\4\23\14\0\1\23\5\0\1\23"+
    "\1\0\4\23\1\73\14\23\14\0\1\23\5\0\1\23"+
    "\1\0\17\23\1\74\1\23\14\0\1\23\5\0\1\23"+
    "\1\0\14\23\1\75\4\23\14\0\1\23\5\0\1\23"+
    "\1\0\11\23\1\76\7\23\14\0\1\23\5\0\1\23"+
    "\1\0\14\23\1\77\4\23\14\0\1\23\5\0\1\23"+
    "\1\0\4\23\1\100\14\23\14\0\1\23\5\0\1\23"+
    "\1\0\5\23\1\101\2\23\1\102\10\23\14\0\1\23"+
    "\5\0\1\23\1\0\15\23\1\103\3\23\14\0\1\23"+
    "\5\0\1\23\1\0\4\23\1\104\14\23\14\0\1\23"+
    "\5\0\1\23\1\0\10\23\1\105\10\23\14\0\1\23"+
    "\5\0\1\23\1\0\12\23\1\106\6\23\14\0\1\23"+
    "\5\0\1\23\1\0\4\23\1\107\14\23\14\0\1\23"+
    "\5\0\1\23\1\0\13\23\1\110\5\23\14\0\1\23"+
    "\5\0\1\23\1\0\5\23\1\111\13\23\14\0\1\23"+
    "\5\0\1\23\1\0\4\23\1\112\14\23\14\0\1\23"+
    "\5\0\1\23\1\0\14\23\1\113\4\23\14\0\1\23"+
    "\5\0\1\23\1\0\12\23\1\114\6\23\14\0\1\23"+
    "\5\0\1\23\1\0\14\23\1\115\4\23\14\0\1\23"+
    "\5\0\1\23\1\0\6\23\1\116\12\23";

  private static int [] zzUnpacktrans() {
    int [] result = new int[1776];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\5\11\1\1\1\11\1\1\2\11"+
    "\15\1\1\11\1\0\1\11\1\0\4\11\52\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[78];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

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



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {    return symbol(ParserSym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return symbol(ParserSym.error);
            }
          // fall through
          case 37: break;
          case 2:
            { 
            }
          // fall through
          case 38: break;
          case 3:
            { return symbol(ParserSym.MOD);
            }
          // fall through
          case 39: break;
          case 4:
            { return symbol(ParserSym.OBracket);
            }
          // fall through
          case 40: break;
          case 5:
            { return symbol(ParserSym.CBracket);
            }
          // fall through
          case 41: break;
          case 6:
            { return symbol(ParserSym.MULT);
            }
          // fall through
          case 42: break;
          case 7:
            { return symbol(ParserSym.PLUS);
            }
          // fall through
          case 43: break;
          case 8:
            { return symbol(ParserSym.MINUS);
            }
          // fall through
          case 44: break;
          case 9:
            { return symbol(ParserSym.DIV);
            }
          // fall through
          case 45: break;
          case 10:
            { return symbol(ParserSym.VALUE, Double.parseDouble(yytext()), Tipo.INT);
            }
          // fall through
          case 46: break;
          case 11:
            { return symbol(ParserSym.DETERMINE);
            }
          // fall through
          case 47: break;
          case 12:
            { return symbol(ParserSym.Endline);
            }
          // fall through
          case 48: break;
          case 13:
            { return symbol(ParserSym.LT);
            }
          // fall through
          case 49: break;
          case 14:
            { return symbol(ParserSym.ASSIGN);
            }
          // fall through
          case 50: break;
          case 15:
            { return symbol(ParserSym.GT);
            }
          // fall through
          case 51: break;
          case 16:
            { return symbol(ParserSym.ID, yytext());
            }
          // fall through
          case 52: break;
          case 17:
            { return symbol(ParserSym.NEQ);
            }
          // fall through
          case 53: break;
          case 18:
            { return symbol(ParserSym.VALUE, yytext().substring(1, yytext().length()-1), Tipo.STRING);
            }
          // fall through
          case 54: break;
          case 19:
            { return symbol(ParserSym.LE);
            }
          // fall through
          case 55: break;
          case 20:
            { return symbol(ParserSym.EQ);
            }
          // fall through
          case 56: break;
          case 21:
            { return symbol(ParserSym.GE);
            }
          // fall through
          case 57: break;
          case 22:
            { return symbol(ParserSym.VALUE, yytext().charAt(1), Tipo.CHAR);
            }
          // fall through
          case 58: break;
          case 23:
            { return symbol(ParserSym.IF_INVOKER);
            }
          // fall through
          case 59: break;
          case 24:
            { return symbol(ParserSym.FOR_INVOKER);
            }
          // fall through
          case 60: break;
          case 25:
            { return symbol(ParserSym.VAR_TYPE, Tipo.INT);
            }
          // fall through
          case 61: break;
          case 26:
            { return symbol(ParserSym.VAR_INVOKER);
            }
          // fall through
          case 62: break;
          case 27:
            { return symbol(ParserSym.VAR_TYPE, Tipo.BOOL);
            }
          // fall through
          case 63: break;
          case 28:
            { return symbol(ParserSym.VAR_TYPE, Tipo.CHAR);
            }
          // fall through
          case 64: break;
          case 29:
            { return symbol(ParserSym.ELSE_INVOKER);
            }
          // fall through
          case 65: break;
          case 30:
            { return symbol(ParserSym.THEN_INVOKER);
            }
          // fall through
          case 66: break;
          case 31:
            { return symbol(ParserSym.VALUE, true, Tipo.BOOL);
            }
          // fall through
          case 67: break;
          case 32:
            { return symbol(ParserSym.ENDIF_INVOKER);
            }
          // fall through
          case 68: break;
          case 33:
            { return symbol(ParserSym.VALUE, false, Tipo.BOOL);
            }
          // fall through
          case 69: break;
          case 34:
            { return symbol(ParserSym.INFER_INVOKER);
            }
          // fall through
          case 70: break;
          case 35:
            { return symbol(ParserSym.ENDFOR_INVOKER);
            }
          // fall through
          case 71: break;
          case 36:
            { return symbol(ParserSym.VAR_TYPE, Tipo.STRING);
            }
          // fall through
          case 72: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java Scanner [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Scanner scanner = null;
        java.io.FileInputStream stream = null;
        java.io.Reader reader = null;
        try {
          stream = new java.io.FileInputStream(argv[i]);
          reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Scanner(reader);
          while ( !scanner.zzAtEOF ) scanner.next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
        finally {
          if (reader != null) {
            try {
              reader.close();
            }
            catch (java.io.IOException e) {
              System.out.println("IO error closing file \""+argv[i]+"\"");
              System.out.println(e);
            }
          }
          if (stream != null) {
            try {
              stream.close();
            }
            catch (java.io.IOException e) {
              System.out.println("IO error closing file \""+argv[i]+"\"");
              System.out.println(e);
            }
          }
        }
      }
    }
  }


}
