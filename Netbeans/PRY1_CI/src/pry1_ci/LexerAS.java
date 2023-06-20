/* The following code was generated by JFlex 1.4.2 on 19/06/23 11:44 PM */

package pry1_ci;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.2
 * on 19/06/23 11:44 PM from the specification file
 * <tt>T:/2023/COMPILADORES/PRYS/Lenguajes-PRY_Part3/Netbeans/PRY1_CI/src/pry1_ci/lexer.jflex</tt>
 */
public class LexerAS implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int CHAR = 4;
  public static final int CADENA = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\55\1\64"+
    "\1\57\1\37\2\0\1\63\1\45\1\46\1\6\1\44\1\54\1\13"+
    "\1\14\1\4\1\12\11\11\1\0\1\53\1\61\1\43\1\60\1\0"+
    "\1\7\17\10\1\41\1\10\1\42\10\10\1\51\1\65\1\52\1\56"+
    "\1\5\1\0\1\21\1\15\1\31\1\34\1\20\1\25\1\30\1\32"+
    "\1\23\1\10\1\35\1\17\1\10\1\22\1\16\2\10\1\27\1\26"+
    "\1\24\1\36\1\10\1\33\1\10\1\40\1\10\1\47\1\0\1\50"+
    "\1\62\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\1\3\1\4\1\5\1\1\2\6"+
    "\1\7\12\4\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\2\34\1\35"+
    "\1\36\1\1\2\37\1\1\1\0\1\40\1\0\2\41"+
    "\2\0\1\42\4\4\1\43\11\4\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\5\52\1\57\2\52\4\0\1\60\4\4\1\61"+
    "\1\4\1\62\7\4\1\63\1\64\1\65\1\66\1\67"+
    "\1\70\1\71\1\72\2\0\1\41\1\0\2\4\1\73"+
    "\1\74\1\75\6\4\1\76\1\4\1\41\1\4\1\77"+
    "\1\100\1\101\4\4\1\102\1\4\1\103\2\4\1\104"+
    "\1\105\1\4\1\106\1\107";

  private static int [] zzUnpackAction() {
    int [] result = new int[156];
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
    "\0\0\0\66\0\154\0\242\0\330\0\242\0\u010e\0\u0144"+
    "\0\u017a\0\u01b0\0\u01e6\0\u021c\0\u0252\0\u0288\0\u02be\0\u02f4"+
    "\0\u032a\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438\0\u046e\0\242"+
    "\0\u04a4\0\u04da\0\242\0\242\0\242\0\242\0\242\0\242"+
    "\0\242\0\242\0\u0510\0\242\0\242\0\u0546\0\u057c\0\242"+
    "\0\242\0\242\0\u05b2\0\u05e8\0\242\0\242\0\u061e\0\u0654"+
    "\0\u068a\0\242\0\u06c0\0\u06f6\0\242\0\u01b0\0\u072c\0\242"+
    "\0\u0762\0\u021c\0\242\0\u0798\0\u07ce\0\u0804\0\u083a\0\u0144"+
    "\0\u0870\0\u08a6\0\u08dc\0\u0912\0\u0948\0\u097e\0\u09b4\0\u09ea"+
    "\0\u0a20\0\u0144\0\242\0\242\0\242\0\242\0\242\0\242"+
    "\0\242\0\242\0\242\0\242\0\242\0\u0a56\0\u0a8c\0\u0ac2"+
    "\0\u0af8\0\u0b2e\0\u0b64\0\u0b9a\0\u0bd0\0\u0c06\0\u0c3c\0\u0c72"+
    "\0\u0ca8\0\u0762\0\u0cde\0\u0d14\0\u0d4a\0\u0d80\0\u0144\0\u0db6"+
    "\0\u0144\0\u0dec\0\u0e22\0\u0e58\0\u0e8e\0\u0ec4\0\u0efa\0\u0f30"+
    "\0\242\0\242\0\242\0\242\0\242\0\242\0\242\0\242"+
    "\0\u0f66\0\u0f9c\0\u0c06\0\u0fd2\0\u1008\0\u103e\0\u0144\0\u0144"+
    "\0\u0144\0\u1074\0\u10aa\0\u10e0\0\u1116\0\u114c\0\u1182\0\u0144"+
    "\0\u11b8\0\u0ca8\0\u11ee\0\u0144\0\u0144\0\u0144\0\u1224\0\u125a"+
    "\0\u1290\0\u12c6\0\u0144\0\u12fc\0\u0144\0\u1332\0\u1368\0\u0144"+
    "\0\u0144\0\u139e\0\u0144\0\u0144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\2\6\1\7\1\10\1\11\1\12\1\10"+
    "\1\13\1\14\1\15\1\4\1\16\2\10\1\17\2\10"+
    "\1\20\1\21\1\22\1\23\1\24\1\10\1\25\1\10"+
    "\1\26\1\27\2\10\1\30\3\10\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\4"+
    "\1\53\1\54\1\55\61\53\1\56\1\57\1\60\1\61"+
    "\1\62\62\60\1\63\70\0\1\6\70\0\1\64\65\0"+
    "\1\10\2\0\3\10\2\0\22\10\1\0\3\10\31\0"+
    "\1\65\57\0\1\66\1\67\1\70\63\66\11\0\2\13"+
    "\1\0\1\71\65\0\1\71\62\0\1\13\1\72\1\73"+
    "\57\0\1\10\2\0\3\10\2\0\1\10\1\74\10\10"+
    "\1\75\7\10\1\0\3\10\30\0\1\10\2\0\3\10"+
    "\2\0\2\10\1\76\17\10\1\0\3\10\30\0\1\10"+
    "\2\0\3\10\2\0\5\10\1\77\2\10\1\100\11\10"+
    "\1\0\3\10\30\0\1\10\2\0\3\10\2\0\12\10"+
    "\1\101\7\10\1\0\3\10\30\0\1\10\2\0\3\10"+
    "\2\0\1\10\1\102\1\103\1\10\1\104\15\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\7\10\1\105"+
    "\12\10\1\0\1\106\2\10\30\0\1\10\2\0\3\10"+
    "\2\0\3\10\1\107\16\10\1\0\3\10\30\0\1\10"+
    "\2\0\3\10\2\0\15\10\1\110\4\10\1\0\3\10"+
    "\30\0\1\10\2\0\3\10\2\0\15\10\1\111\4\10"+
    "\1\0\3\10\30\0\1\10\2\0\3\10\2\0\1\10"+
    "\1\112\20\10\1\0\3\10\66\0\1\113\66\0\1\114"+
    "\64\0\1\115\65\0\1\116\65\0\1\117\22\0\1\53"+
    "\2\0\61\53\4\0\1\55\63\0\2\120\1\0\17\120"+
    "\1\121\1\120\1\122\2\120\1\123\34\120\1\124\1\120"+
    "\63\0\1\125\4\0\1\62\63\0\2\120\1\0\12\120"+
    "\1\126\4\120\1\127\1\120\1\130\1\131\1\120\1\132"+
    "\33\120\1\133\1\134\1\135\1\136\2\137\2\136\1\140"+
    "\1\141\57\136\2\0\1\70\74\0\2\142\60\0\1\10"+
    "\2\0\3\10\2\0\1\10\1\143\20\10\1\0\3\10"+
    "\30\0\1\10\2\0\3\10\2\0\3\10\1\144\16\10"+
    "\1\0\3\10\30\0\1\10\2\0\3\10\2\0\6\10"+
    "\1\145\2\10\1\146\10\10\1\0\3\10\30\0\1\10"+
    "\2\0\3\10\2\0\7\10\1\147\12\10\1\0\3\10"+
    "\30\0\1\10\2\0\3\10\2\0\21\10\1\150\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\12\10\1\151"+
    "\7\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\1\10\1\152\20\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\2\10\1\153\17\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\12\10\1\154\7\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\11\10\1\155"+
    "\10\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\7\10\1\156\12\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\4\10\1\157\15\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\6\10\1\160\13\10\1\0"+
    "\3\10\106\0\1\161\65\0\1\162\65\0\1\163\65\0"+
    "\1\164\65\0\1\165\65\0\1\166\65\0\1\167\65\0"+
    "\1\170\2\0\1\136\2\137\2\136\1\171\60\136\5\137"+
    "\1\172\60\137\1\136\2\137\1\136\1\173\1\171\60\136"+
    "\1\141\2\0\2\141\1\174\60\141\5\0\1\10\2\0"+
    "\3\10\2\0\2\10\1\175\17\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\4\10\1\176\15\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\10\10\1\177"+
    "\11\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\3\10\1\200\16\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\3\10\1\201\16\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\4\10\1\202\15\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\11\10\1\203"+
    "\10\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\6\10\1\204\13\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\22\10\1\0\1\10\1\205\1\206\30\0"+
    "\1\10\2\0\3\10\2\0\21\10\1\207\1\0\3\10"+
    "\30\0\1\10\2\0\3\10\2\0\12\10\1\210\7\10"+
    "\1\0\3\10\30\0\1\10\2\0\3\10\2\0\2\10"+
    "\1\211\17\10\1\0\3\10\23\0\1\136\2\137\1\136"+
    "\1\212\1\171\60\136\4\137\1\70\1\172\60\137\1\141"+
    "\2\0\1\141\1\212\1\174\60\141\5\0\1\10\2\0"+
    "\3\10\2\0\3\10\1\213\16\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\20\10\1\214\1\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\7\10\1\215"+
    "\12\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\3\10\1\216\16\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\5\10\1\217\14\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\12\10\1\220\7\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\3\10\1\221"+
    "\16\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\12\10\1\222\7\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\3\10\1\223\16\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\4\10\1\224\15\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\13\10\1\225"+
    "\6\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\6\10\1\226\13\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\4\10\1\227\15\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\5\10\1\230\14\10\1\0"+
    "\3\10\30\0\1\10\2\0\3\10\2\0\5\10\1\231"+
    "\14\10\1\0\3\10\30\0\1\10\2\0\3\10\2\0"+
    "\5\10\1\232\14\10\1\0\3\10\30\0\1\10\2\0"+
    "\3\10\2\0\17\10\1\233\2\10\1\0\3\10\30\0"+
    "\1\10\2\0\3\10\2\0\7\10\1\234\12\10\1\0"+
    "\3\10\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5076];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\1\1\1\11\21\1\1\11\2\1\10\11"+
    "\1\1\2\11\2\1\3\11\2\1\2\11\3\1\1\11"+
    "\1\1\1\0\1\11\1\0\1\1\1\11\2\0\1\11"+
    "\17\1\13\11\10\1\4\0\17\1\10\11\2\0\1\1"+
    "\1\0\40\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[156];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

    int line = 1;
    int column = 1;
    String msgErr = "";
    StringBuffer string = new StringBuffer();

    public Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    public Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    public int getYYLine() {
        return yyline+1;
    }

    public int getYYColumn() {
        return yycolumn+1;
    }

    public String getMsgErr() {
        return msgErr;
    }

    public void SetMsgErr() {
        msgErr = "";
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexerAS(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LexerAS(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 144) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
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
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 54: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\f');
          }
        case 72: break;
        case 24: 
          { return symbol(sym.MODULO);
          }
        case 73: break;
        case 57: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\"');
          }
        case 74: break;
        case 14: 
          { return symbol(sym.LLAVESCORCHETECIERRA);
          }
        case 75: break;
        case 44: 
          { string.append('\t');
          }
        case 76: break;
        case 56: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\'');
          }
        case 77: break;
        case 49: 
          { return symbol(sym.INT);
          }
        case 78: break;
        case 40: 
          { return symbol(sym.GREATER_THAN_OR_EQ);
          }
        case 79: break;
        case 15: 
          { return symbol(sym.LLAVESCUADABRE);
          }
        case 80: break;
        case 1: 
          { msgErr = "[Error lexico] Caracter Ilegal: "+yytext()+"\" en la linea "+(yyline+1)+", columna "+(yycolumn+1);
        System.err.println(msgErr);
          }
        case 81: break;
        case 70: 
          { return symbol(sym.SYS_READ);
          }
        case 82: break;
        case 59: 
          { return symbol(sym.ELIF);
          }
        case 83: break;
        case 22: 
          { return symbol(sym.GREATER_THAN);
          }
        case 84: break;
        case 34: 
          { return symbol(sym.MINUSMINUS);
          }
        case 85: break;
        case 11: 
          { return symbol(sym.PARENTESISABRE);
          }
        case 86: break;
        case 30: 
          { string.append('\\');
          }
        case 87: break;
        case 68: 
          { return symbol(sym.RETURN);
          }
        case 88: break;
        case 45: 
          { string.append('\r');
          }
        case 89: break;
        case 52: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\n');
          }
        case 90: break;
        case 10: 
          { return symbol(sym.PLUS);
          }
        case 91: break;
        case 20: 
          { return symbol(sym.CONJUNCION);
          }
        case 92: break;
        case 13: 
          { return symbol(sym.LLAVESCORCHETEABRE);
          }
        case 93: break;
        case 71: 
          { return symbol(sym.SYS_PRINT);
          }
        case 94: break;
        case 28: 
          { msgErr = "[Error lexico] String incompleto:" + yytext() + "\" en la linea "+(yyline+1)+", columna "+(yycolumn+1);
    System.err.println(msgErr);
          }
        case 95: break;
        case 19: 
          { return symbol(sym.NEGACION);
          }
        case 96: break;
        case 4: 
          { return symbol(sym.Identificador, yytext());
          }
        case 97: break;
        case 51: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\b');
          }
        case 98: break;
        case 41: 
          { return symbol(sym.LESS_THAN_OR_EQ);
          }
        case 99: break;
        case 2: 
          { /*ignore*/
          }
        case 100: break;
        case 36: 
          { return symbol(sym.DO);
          }
        case 101: break;
        case 5: 
          { return symbol(sym.TIMES);
          }
        case 102: break;
        case 60: 
          { return symbol(sym.ELSE);
          }
        case 103: break;
        case 46: 
          { string.append('\"');
          }
        case 104: break;
        case 12: 
          { return symbol(sym.PARENTESISCIERRA);
          }
        case 105: break;
        case 48: 
          { return symbol(sym.L_FLOTANTE, Float.valueOf(yytext()));
          }
        case 106: break;
        case 61: 
          { return symbol(sym.L_BOOLEANO, true);
          }
        case 107: break;
        case 8: 
          { return symbol(sym.FIN_EXPRESION);
          }
        case 108: break;
        case 66: 
          { return symbol(sym.WHILE);
          }
        case 109: break;
        case 63: 
          { return symbol(sym.BREAK);
          }
        case 110: break;
        case 35: 
          { return symbol(sym.IF);
          }
        case 111: break;
        case 3: 
          { return symbol(sym.DIVI);
          }
        case 112: break;
        case 47: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, yytext().charAt(0));
          }
        case 113: break;
        case 39: 
          { return symbol(sym.NOT_EQ);
          }
        case 114: break;
        case 18: 
          { return symbol(sym.COMA);
          }
        case 115: break;
        case 9: 
          { return symbol(sym.EQ);
          }
        case 116: break;
        case 62: 
          { return symbol(sym.CHAR);
          }
        case 117: break;
        case 69: 
          { return symbol(sym.BOOL);
          }
        case 118: break;
        case 50: 
          { return symbol(sym.FOR);
          }
        case 119: break;
        case 42: 
          { msgErr = "[Error lexico] Secuencia de escape ilegal:" + yytext() + "\" en la linea "+(yyline+1)+", columna "+(yycolumn+1);
    System.err.println(msgErr);
          }
        case 120: break;
        case 64: 
          { return symbol(sym.FLOAT);
          }
        case 121: break;
        case 43: 
          { string.append('\n');
          }
        case 122: break;
        case 38: 
          { return symbol(sym.PLUSPLUS);
          }
        case 123: break;
        case 31: 
          { msgErr = "[Error lexico] Literal caracter incompleto:" + yytext() + "\" en la linea "+(yyline+1)+", columna "+(yycolumn+1);
    System.err.println(msgErr);
          }
        case 124: break;
        case 17: 
          { return symbol(sym.SEMI);
          }
        case 125: break;
        case 21: 
          { return symbol(sym.DISYUNCION);
          }
        case 126: break;
        case 27: 
          { string.append(yytext());
          }
        case 127: break;
        case 7: 
          { return symbol(sym.MINUS);
          }
        case 128: break;
        case 53: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\t');
          }
        case 129: break;
        case 29: 
          { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString());
          }
        case 130: break;
        case 6: 
          { return symbol(sym.L_ENTERO, Integer.valueOf(yytext()));
          }
        case 131: break;
        case 67: 
          { return symbol(sym.STRING);
          }
        case 132: break;
        case 25: 
          { yybegin(CHAR);
          }
        case 133: break;
        case 65: 
          { return symbol(sym.L_BOOLEANO, false);
          }
        case 134: break;
        case 26: 
          { yybegin(CADENA); string.setLength(0);
          }
        case 135: break;
        case 23: 
          { return symbol(sym.LESS_THAN);
          }
        case 136: break;
        case 58: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\\');
          }
        case 137: break;
        case 32: 
          { return symbol(sym.POWER);
          }
        case 138: break;
        case 16: 
          { return symbol(sym.LLAVESCUADCIERRA);
          }
        case 139: break;
        case 55: 
          { yybegin(YYINITIAL);
						 return symbol(sym.L_CHAR, '\r');
          }
        case 140: break;
        case 37: 
          { return symbol(sym.EQEQ);
          }
        case 141: break;
        case 33: 
          { 
          }
        case 142: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
