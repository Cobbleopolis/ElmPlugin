package com.davidmis.elmplugin;

import com.davidmis.elmplugin.psi.ElmTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.text.CharArrayUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;

class ElmLexer implements FlexLexer {

    private static final int ZZ_BUFFERSIZE = 16384;
    public static final int INCOMMENT = 2;
    public static final int YYINITIAL = 0;
    private static final int[] ZZ_LEXSTATE = new int[]{0, 0, 1, 1};
    private static final String ZZ_CMAP_PACKED = "\t     \t#$ \f \n\" ! \n  \t \n\r\n\n\n \n , \b\n \b \b \b \b Ŀ\b r\b \f\b \b\t \b \b \b \b \b \b ,\b &\b \b \b\b E\b &\b \b \b! &\b \b \'\bH \b \b. \b \b# \b c\b \b \b \b\n \b \b \b \b \b0 &\b \bŒ 6\b \b \b \n\b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \t\b \b \b \b \b \b \b \b \b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b\b \bK \b\b \b \b \n\b \b& \b# \b\b \b \b \n\b \b \b  \b \b# \b\b \b \b \b& \b# \b \b \t\b \b \b: 0\b \b\f \b: \b \b \b \b \b \b \b \b \b \b \b \b \b\t \b \b \b \b\" \b? \b\b \"\b \bt \"\b \b \b% \bJ &\b\n )\b Z\b D\b R\b \b ?\b \b \b \b \b \b \'\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \'\b \bE U\b\f ɬ\b \b\b\n \b K\b \r\b \b \b \b \r\b \b 4\b# \b \bC X\b\b )\bW \b3 \b \b΋ l\b \b Z\b \b \b &\b \b \b\b \b \b \b \b 5\b \b \b \b \b \b \b \r\b \b \bt \b\r \b \b \b \n\b \b \b \b \b \b \b \b \b \b \bົ \b* \b \b V\b \b Z\b \b (\b ^\b \b8 \bȀ ᦶ\bJ 冦\bZ �?\bݳ ⮤\b⅜ Į\b ;\b \b\f \b \b \n\b \r\b \b \b \b \b l\b! ū\b @\b 6\b( \f\bt \b \b$ \b \b Y\b \b \b \b \b# ";
    private static final char[] ZZ_CMAP = zzUnpackCMap("\t     \t#$ \f \n\" ! \n  \t \n\r\n\n\n \n , \b\n \b \b \b \b Ŀ\b r\b \f\b \b\t \b \b \b \b \b \b ,\b &\b \b \b\b E\b &\b \b \b! &\b \b \'\bH \b \b. \b \b# \b c\b \b \b \b\n \b \b \b \b \b0 &\b \bŒ 6\b \b \b \n\b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \t\b \b \b \b \b \b \b \b \b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b\b \bK \b\b \b \b \n\b \b& \b# \b\b \b \b \n\b \b \b  \b \b# \b\b \b \b \b& \b# \b \b \t\b \b \b: 0\b \b\f \b: \b \b \b \b \b \b \b \b \b \b \b \b \b\t \b \b \b \b\" \b? \b\b \"\b \bt \"\b \b \b% \bJ &\b\n )\b Z\b D\b R\b \b ?\b \b \b \b \b \b \'\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \'\b \bE U\b\f ɬ\b \b\b\n \b K\b \r\b \b \b \b \r\b \b 4\b# \b \bC X\b\b )\bW \b3 \b \b΋ l\b \b Z\b \b \b &\b \b \b\b \b \b \b \b 5\b \b \b \b \b \b \b \r\b \b \bt \b\r \b \b \b \n\b \b \b \b \b \b \b \b \b \b \bົ \b* \b \b V\b \b Z\b \b (\b ^\b \b8 \bȀ ᦶ\bJ 冦\bZ �?\bݳ ⮤\b⅜ Į\b ;\b \b\f \b \b \n\b \r\b \b \b \b \b l\b! ū\b @\b 6\b( \f\bt \b \b$ \b \b Y\b \b \b \b \b# ");
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ACTION_PACKED_0 = "\b\t\n \f\r\b \f     ";
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_ROWMAP_PACKED_0 = "   % J o  ¹ Þ ă Ĩ �? Ų Ɨ Ƽ ǡ Ȇ ȫ �? ɵ ʚ ʿ ˤ J J J J ̉ ̮ ¹ J ͓ ͸ �? ς ϧ Ќ б і б ă ă ѻ Ҡ Ӆ Ӫ �? Դ ՙ վ ă ă ֣ ׈ ׭ ؒ ط J �? J ٜ �? ڦ ۋ ۰ ܕ ܺ ݟ ބ ީ ߎ ߳ ࠘ J ٜ ࠽ ࡢ ࢇ ࢬ ࣑ ă ă ࣶ ă छ ă ă ă ी ॥ ঊ য ৔ ࡢ ৹ ਞ ੃ ੨ �? ă য લ ă ૗ ă ă ă ૼ ă ς";
    private static final int[] ZZ_TRANS = zzUnpackTrans();
    private static final String ZZ_TRANS_PACKED_0 = "\b\b\t\n\f\r\b\b\b\b& % $ !  ! \"# \t \b \b \t$# %&! \b \b\'\b(\b\b)\b\r \b \n\b*\t\b\r \b \b+\b\b,\b\r \b -\b\r \b \b.\f\b/\r \b \t\b0\n\b\r \b \b1\f\b\r \b \b2\b3\b\r \b \t\b4\n\b\r \b \n\b5\t\b\r \b \b6\b   7!  # 8!  ! 9#  :  ! ;# ! #  %$# %\" \b \r\b<\b\r \b \b=\b\r \b \b>\b\r \b \r\b?\b\r \b \b@\b\b\r \b \bA\f\b\r \b \r\bB\b\r \b \bC\f\b\r \b \bD\b\r \b \bE\b\r \b \bF\b\b\r \b \bG\b\t H IJIKLI\t \b \n\bM\t\b\r \b \bN\b\r \b \bO\b\r \b \bP\b\r \b Q\b\r \b \bR\b\r \b \n\bS\t\b\r \b \bT\b\r \b \bU\b\r \b \t\bV\n\b\r \b \bW\b\r \b \bX\b YZYIJI[LIJI\\LI\t \b \b]\b\r \b ^\b\r \b \b_\b\r \b \b`\b\r \b \ba\r\b\r \b \bb\b Yc$YdYIJI9LI\t \b \be\b\r \b \bf\b\r \b \bg\b\r \b \bh\b\r \b \bi\b YjY\t \b \bk\b\n l ";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final char[] EMPTY_BUFFER = new char[0];
    private static final int YYEOF = -1;
    private static Reader zzReader = null;
    private static final String[] ZZ_ERROR_MSG = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\t\t\t  \t\t\r\t  \f   \b";
    private int zzState;
    private int zzLexicalState;
    private CharSequence zzBuffer;
    private char[] zzBufferArray;
    private int zzMarkedPos;
    private int zzPushbackPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private boolean zzAtBOL;
    private boolean zzAtEOF;
    private boolean zzEOFDone;
    private final LinkedList states;


    private static int[] zzUnpackAction() {
        int[] result = new int[108];
        byte offset = 0;
        zzUnpackAction("\b\t\n \f\r\b \f     ", offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;
        int j = offset;
        int l = packed.length();

        while (i < l) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);

            while (true) {
                result[j++] = value;
                --count;
                if (count <= 0) {
                    break;
                }
            }
        }

        return j;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[108];
        byte offset = 0;
        zzUnpackRowMap("   % J o  ¹ Þ ă Ĩ �? Ų Ɨ Ƽ ǡ Ȇ ȫ �? ɵ ʚ ʿ ˤ J J J J ̉ ̮ ¹ J ͓ ͸ �? ς ϧ Ќ б і б ă ă ѻ Ҡ Ӆ Ӫ �? Դ ՙ վ ă ă ֣ ׈ ׭ ؒ ط J �? J ٜ �? ڦ ۋ ۰ ܕ ܺ ݟ ބ ީ ߎ ߳ ࠘ J ٜ ࠽ ࡢ ࢇ ࢬ ࣑ ă ă ࣶ ă छ ă ă ă ी ॥ ঊ য ৔ ࡢ ৹ ਞ ੃ ੨ �? ă য લ ă ૗ ă ă ă ૼ ă ς", offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;
        int j = offset;

        int high;
        for (int l = packed.length(); i < l; result[j++] = high | packed.charAt(i++)) {
            high = packed.charAt(i++) << 16;
        }

        return j;
    }

    private static int[] zzUnpackTrans() {
        int[] result = new int[2849];
        byte offset = 0;
        zzUnpackTrans("\b\b\t\n\f\r\b\b\b\b& % $ !  ! \"# \t \b \b \t$# %&! \b \b\'\b(\b\b)\b\r \b \n\b*\t\b\r \b \b+\b\b,\b\r \b -\b\r \b \b.\f\b/\r \b \t\b0\n\b\r \b \b1\f\b\r \b \b2\b3\b\r \b \t\b4\n\b\r \b \n\b5\t\b\r \b \b6\b   7!  # 8!  ! 9#  :  ! ;# ! #  %$# %\" \b \r\b<\b\r \b \b=\b\r \b \b>\b\r \b \r\b?\b\r \b \b@\b\b\r \b \bA\f\b\r \b \r\bB\b\r \b \bC\f\b\r \b \bD\b\r \b \bE\b\r \b \bF\b\b\r \b \bG\b\t H IJIKLI\t \b \n\bM\t\b\r \b \bN\b\r \b \bO\b\r \b \bP\b\r \b Q\b\r \b \bR\b\r \b \n\bS\t\b\r \b \bT\b\r \b \bU\b\r \b \t\bV\n\b\r \b \bW\b\r \b \bX\b YZYIJI[LIJI\\LI\t \b \b]\b\r \b ^\b\r \b \b_\b\r \b \b`\b\r \b \ba\r\b\r \b \bb\b Yc$YdYIJI9LI\t \b \be\b\r \b \bf\b\r \b \bg\b\r \b \bh\b\r \b \bi\b YjY\t \b \bk\b\n l ", offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;
        int j = offset;
        int l = packed.length();

        while (i < l) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            int var8 = value - 1;

            while (true) {
                result[j++] = var8;
                --count;
                if (count <= 0) {
                    break;
                }
            }
        }

        return j;
    }

    private static int[] zzUnpackAttribute() {
        int[] result = new int[108];
        byte offset = 0;
        zzUnpackAttribute("\t\t\t  \t\t\r\t  \f   \b", offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;
        int j = offset;
        int l = packed.length();

        while (i < l) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);

            while (true) {
                result[j++] = value;
                --count;
                if (count <= 0) {
                    break;
                }
            }
        }

        return j;
    }

    private void yypushstate(int state) {
        this.states.addFirst(Integer.valueOf(this.yystate()));
        this.yybegin(state);
    }

    private void yypopstate() {
        int state = ((Integer) this.states.removeFirst()).intValue();
        this.yybegin(state);
    }

    ElmLexer(Reader in) {
        this.zzLexicalState = 0;
        this.zzBuffer = "";
        this.zzAtBOL = true;
        this.states = new LinkedList();
        zzReader = in;
    }

    ElmLexer(InputStream in) {
        this((Reader) (new InputStreamReader(in)));
    }

    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[65536];
        int i = 0;
        int j = 0;

        while (i < 1212) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);

            while (true) {
                map[j++] = value;
                --count;
                if (count <= 0) {
                    break;
                }
            }
        }

        return map;
    }

    public final int getTokenStart() {
        return this.zzStartRead;
    }

    public final int getTokenEnd() {
        return this.getTokenStart() + this.yylength();
    }

    public void reset(CharSequence buffer, int start, int end, int initialState) {
        this.zzBuffer = buffer;
        this.zzBufferArray = CharArrayUtil.fromSequenceWithoutCopying(buffer);
        this.zzCurrentPos = this.zzMarkedPos = this.zzStartRead = start;
        this.zzPushbackPos = 0;
        this.zzAtEOF = false;
        this.zzAtBOL = true;
        this.zzEndRead = end;
        this.yybegin(initialState);
    }

    private boolean zzRefill() throws IOException {
        return true;
    }

    public final int yystate() {
        return this.zzLexicalState;
    }

    public final void yybegin(int newState) {
        this.zzLexicalState = newState;
    }

    public final CharSequence yytext() {
        return this.zzBuffer.subSequence(this.zzStartRead, this.zzMarkedPos);
    }

    public final char yycharat(int pos) {
        return this.zzBufferArray != null ? this.zzBufferArray[this.zzStartRead + pos] : this.zzBuffer.charAt(this.zzStartRead + pos);
    }

    public final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }

    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException var4) {
            message = ZZ_ERROR_MSG[0];
        }

        throw new Error(message);
    }

    public void yypushback(int number) {
        if (number > this.yylength()) {
            this.zzScanError(2);
        }

        this.zzMarkedPos -= number;
    }

    private void zzDoEOF() {
        if (!this.zzEOFDone) {
            this.zzEOFDone = true;
        }
    }

    public IElementType advance() throws IOException {
        int zzEndReadL = this.zzEndRead;
        CharSequence zzBufferL = this.zzBuffer;
        char[] zzBufferArrayL = this.zzBufferArray;
        char[] zzCMapL = ZZ_CMAP;
        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            int zzMarkedPosL = this.zzMarkedPos;
            int zzAction = -1;
            int zzCurrentPosL = this.zzCurrentPos = this.zzStartRead = zzMarkedPosL;
            this.zzState = ZZ_LEXSTATE[this.zzLexicalState];

            int zzInput;
            while (true) {
                if (zzCurrentPosL < zzEndReadL) {
                    zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++);
                } else {
                    if (this.zzAtEOF) {
                        zzInput = -1;
                        break;
                    }

                    this.zzCurrentPos = zzCurrentPosL;
                    this.zzMarkedPos = zzMarkedPosL;
                    boolean zzNext = this.zzRefill();
                    zzCurrentPosL = this.zzCurrentPos;
                    zzMarkedPosL = this.zzMarkedPos;
                    zzBufferL = this.zzBuffer;
                    zzEndReadL = this.zzEndRead;
                    if (zzNext) {
                        zzInput = -1;
                        break;
                    }

                    zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++);
                }

                int var14 = zzTransL[zzRowMapL[this.zzState] + zzCMapL[zzInput]];
                if (var14 != -1) {
                    this.zzState = var14;
                    int zzAttributes = zzAttrL[this.zzState];
                    if ((zzAttributes & 1) != 1) {
                        continue;
                    }

                    zzAction = this.zzState;
                    zzMarkedPosL = zzCurrentPosL;
                    if ((zzAttributes & 8) != 8) {
                        continue;
                    }
                }
                break;
            }

            this.zzMarkedPos = zzMarkedPosL;
            switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                case 1:
                    return ElmTypes.WHITESPACE;
                case 2:
                    return ElmTypes.COMMENT;
                case 3:
                    return TokenType.BAD_CHARACTER;
                case 4:
                    return ElmTypes.IDENTIFIER;
                case 5:
                    return ElmTypes.NUMBER;
                case 6:
                    return ElmTypes.DOT;
                case 7:
                    return ElmTypes.EQUALS;
                case 8:
                    return ElmTypes.COLON;
                case 9:
                    return ElmTypes.LPAREN;
                case 10:
                    return ElmTypes.RPAREN;
                case 11:
                    return ElmTypes.DOTDOT;
                case 12:
                    return ElmTypes.IF;
                case 13:
                    return ElmTypes.IN;
                case 14:
                    return ElmTypes.AS;
                case 15:
                    return ElmTypes.OF;
                case 16:
                    this.yypushstate(2);
                    this.yypushback(2);
                    return ElmTypes.COMMENT;
                case 17:
                    return ElmTypes.STRING;
                case 18:
                    this.yypopstate();
                    return ElmTypes.COMMENT;
                case 19:
                    return ElmTypes.THEN;
                case 20:
                    return ElmTypes.TYPE;
                case 21:
                    return ElmTypes.ELSE;
                case 22:
                    return ElmTypes.CASE;
                case 23:
                    return ElmTypes.OPEN;
                case 24:
                    return ElmTypes.DATA;
                case 25:
                    return ElmTypes.WHERE;
                case 26:
                    return ElmTypes.IMPORT;
                case 27:
                    return ElmTypes.HIDING;
                case 28:
                    return ElmTypes.EXPORT;
                case 29:
                    return ElmTypes.MODULE;
                case 30:
                    return ElmTypes.FOREIGN;
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                    break;
                default:
                    if (zzInput == -1 && this.zzStartRead == this.zzCurrentPos) {
                        this.zzAtEOF = true;
                        this.zzDoEOF();
                        return null;
                    }

                    this.zzScanError(1);
            }
        }
    }

}
