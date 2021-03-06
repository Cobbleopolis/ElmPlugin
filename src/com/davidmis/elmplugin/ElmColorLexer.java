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

class ElmColorLexer implements FlexLexer {

    private static final int ZZ_BUFFERSIZE = 16384;
    public static final int INCOMMENT = 2;
    public static final int YYINITIAL = 0;
    private static final int[] ZZ_LEXSTATE = new int[]{0, 0, 1, 1};
    private static final String ZZ_CMAP_PACKED = "\t     3\t22212\f2\n0 6/5 \n#$\n+\"\n*(\n&),\n.%!\n222\t2\'\r\n-\n\n \n47+ \b\n \b \b \b \b Ŀ\b r\b \f\b \b\t \b \b \b \b \b \b ,\b &\b \b \b\b E\b &\b \b \b! &\b \b \'\bH \b \b. \b \b# \b c\b \b \b \b\n \b \b \b \b \b0 &\b \bŒ 6\b \b \b \n\b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \t\b \b \b \b \b \b \b \b \b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b\b \bK \b\b \b \b \n\b \b& \b# \b\b \b \b \n\b \b \b  \b \b# \b\b \b \b \b& \b# \b \b \t\b \b \b: 0\b \b\f \b: \b \b \b \b \b \b \b \b \b \b \b \b \b\t \b \b \b \b\" \b? \b\b \"\b \bt \"\b \b \b% \bJ &\b\n )\b Z\b D\b R\b \b ?\b \b \b \b \b \b \'\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \'\b \bE U\b\f ɬ\b \b\b\n \b K\b \r\b \b \b \b \r\b \b 4\b# \b \bC X\b\b )\bW \b3 \b \b΋ l\b \b Z\b \b \b &\b \b \b\b \b \b \b \b 5\b \b \b \b \b \b \b \r\b \b \bt \b\r \b \b \b \n\b \b \b \b \b \b \b \b \b \b \bົ \b* \b \b V\b \b Z\b \b (\b ^\b \b8 \bȀ ᦶ\bJ 冦\bZ ҍ\bݳ ⮤\b⅜ Į\b ;\b \b\f \b \b \n\b \r\b \b \b \b \b l\b! ū\b @\b 6\b( \f\bt \b \b$ \b \b Y\b \b \b \b \b# ";
    private static final char[] ZZ_CMAP = zzUnpackCMap("\t     3\t22212\f2\n0 6/5 \n#$\n+\"\n*(\n&),\n.%!\n222\t2\'\r\n-\n\n \n47+ \b\n \b \b \b \b Ŀ\b r\b \f\b \b\t \b \b \b \b \b \b ,\b &\b \b \b\b E\b &\b \b \b! &\b \b \'\bH \b \b. \b \b# \b c\b \b \b \b\n \b \b \b \b \b0 &\b \bŒ 6\b \b \b \n\b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \t\b \b \b \b \b \b \b \b \b# \b\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b\b \bK \b\b \b \b \n\b \b& \b# \b\b \b \b \n\b \b \b  \b \b# \b\b \b \b \b& \b# \b \b \t\b \b \b: 0\b \b\f \b: \b \b \b \b \b \b \b \b \b \b \b \b \b\t \b \b \b \b\" \b? \b\b \"\b \bt \"\b \b \b% \bJ &\b\n )\b Z\b D\b R\b \b ?\b \b \b \b \b \b \'\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \'\b \bE U\b\f ɬ\b \b\b\n \b K\b \r\b \b \b \b \r\b \b 4\b# \b \bC X\b\b )\bW \b3 \b \b΋ l\b \b Z\b \b \b &\b \b \b\b \b \b \b \b 5\b \b \b \b \b \b \b \r\b \b \bt \b\r \b \b \b \n\b \b \b \b \b \b \b \b \b \b \bົ \b* \b \b V\b \b Z\b \b (\b ^\b \b8 \bȀ ᦶ\bJ 冦\bZ ҍ\bݳ ⮤\b⅜ Į\b ;\b \b\f \b \b \n\b \r\b \b \b \b \b l\b! ū\b @\b 6\b( \f\bt \b \b$ \b \b Y\b \b \b \b \b# ");
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ACTION_PACKED_0 = " \b \t\n \n \b \n  \n";
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_ROWMAP_PACKED_0 = "   8 p ¨ à Ę p Ő ƈ ǀ Ǹ Ȱ ɨ ʠ ˘ ̐ ͈ ΀ θ ϰ Ш Ѡ Ҙ Ӑ Ԉ Հ ո ְ ר ؠ ٘ ڐ ۈ ܀ ܸ ݰ ި ߠ ࠘ ࡐ ࢈ ࣀ ࣸ र २ Ę p ঠ ৘ ਐ ੈ ઀ સ ૰ ନ ૰ ƈ ୠ ஘ ௐ ఈ ీ ౸ ರ ೨ ഠ ൘ ඐ ෈ ฀ ุ ๰ ຨ ໠ ༘ ཐ ྈ ࿀ ࿸ ူ ၨ ƈ Ⴀ ი p ਐ p ᄐ ᅈ ᆀ ᆸ ᇰ ረ በ ኘ ዐ ገ ፀ ፸ Ꮀ Ꮸ ᐠ ᑘ ᒐ ᓈ ᔀ ᔸ p ᄐ ᕰ ᖨ ᗠ ᘘ ᙐ ᚈ ᛀ ᛸ ᜰ ᝨ ហ ៘ ᠐ ᡈ ᖨ ᢀ ᢸ ᣰ ᠐ ᤨ ᥠ ੈ";
    private static final int[] ZZ_TRANS = zzUnpackTrans();
    private static final String ZZ_TRANS_PACKED_0 = "\b\t\t\n\f\r\t\t\t\t\t !\"#\t$%&\'()*+,-./2,9 8 01  14 2324502\t \t \"\t \n66 784 \t \t9\t9\b\t:\t \t \n\t;\t \t \t<\b\t=\t \t >!\t \t \t?\f\t:\t \t \n\t@\t \t \t\t?\t \t \tA9\t \t \t9\t<\t \t \t\tB\t \t \n\tC\t \t \n\tD\t \t \tE\t \t \tF\t \t \tG\tH\t \t \n\tI\t \t \tJ\t \t K\tL\t \t \t\tM\t \t \tN\t \t \n\tO\t \t \t@\t \t \tP\n\tQ\t \t  \tR\t \t \tS\t8 8 8 9 8 6  5  , 2, T4 0 60 U4 232V502 W1 232X51232502 766 75 \t \r\t\t \t \tY\t \t \tZ\t \t \r\t[\t \t \t\\\t \t \t[\t \t \tR\t \t ]!\t \t \t^\t \t \t_\t \t \t`\t \t \ta\t \t \tb\t \t \n\tc\t \t \td\t \t \n\te\t \t \t\tQ\t \t \tf\t \t \tg\t \t \f\th\t \t \t@\t \t \ti\t \t \tj\t \t \tR\t \t \tk\t l2 mnmop0m\t \t \tq\t \t \t9\t \t \t9\t \t r!\t \t \t\ts\t \t \t\t9\t \t \t9\t \t \tt\t \t \t[\t \t \tR\t \t \t\t@\t \t \tb\t \t \tR\t \t \tu\t \t v!\t \t \tb\t \t \tg\t \t \tw\t \t \tx\t\t yz1ymnm{p1mnm|p0m\t \t }!\t \t \t~\t \t \t9\t \t \t[\t \t \t\te\t \t \t\t \t \t!\t \t \t@\t\t y7y1ymnmVp0m\t \t \tZ\t \t \t9\t \t \tR\t\t y1y 1 ";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final char[] EMPTY_BUFFER = new char[0];
    private static final int YYEOF = -1;
    private static Reader zzReader = null;
    private static final String[] ZZ_ERROR_MSG = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\t\t\'\t  \t\t\t  \b   ";
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
        int[] result = new int[131];
        byte offset = 0;
        zzUnpackAction(" \b \t\n \n \b \n  \n", offset, result);
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
        int[] result = new int[131];
        byte offset = 0;
        zzUnpackRowMap("   8 p ¨ à Ę p Ő ƈ ǀ Ǹ Ȱ ɨ ʠ ˘ ̐ ͈ ΀ θ ϰ Ш Ѡ Ҙ Ӑ Ԉ Հ ո ְ ר ؠ ٘ ڐ ۈ ܀ ܸ ݰ ި ߠ ࠘ ࡐ ࢈ ࣀ ࣸ र २ Ę p ঠ ৘ ਐ ੈ ઀ સ ૰ ନ ૰ ƈ ୠ ஘ ௐ ఈ ీ ౸ ರ ೨ ഠ ൘ ඐ ෈ ฀ ุ ๰ ຨ ໠ ༘ ཐ ྈ ࿀ ࿸ ူ ၨ ƈ Ⴀ ი p ਐ p ᄐ ᅈ ᆀ ᆸ ᇰ ረ በ ኘ ዐ ገ ፀ ፸ Ꮀ Ꮸ ᐠ ᑘ ᒐ ᓈ ᔀ ᔸ p ᄐ ᕰ ᖨ ᗠ ᘘ ᙐ ᚈ ᛀ ᛸ ᜰ ᝨ ហ ៘ ᠐ ᡈ ᖨ ᢀ ᢸ ᣰ ᠐ ᤨ ᥠ ੈ", offset, result);
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
        int[] result = new int[6552];
        byte offset = 0;
        zzUnpackTrans("\b\t\t\n\f\r\t\t\t\t\t !\"#\t$%&\'()*+,-./2,9 8 01  14 2324502\t \t \"\t \n66 784 \t \t9\t9\b\t:\t \t \n\t;\t \t \t<\b\t=\t \t >!\t \t \t?\f\t:\t \t \n\t@\t \t \t\t?\t \t \tA9\t \t \t9\t<\t \t \t\tB\t \t \n\tC\t \t \n\tD\t \t \tE\t \t \tF\t \t \tG\tH\t \t \n\tI\t \t \tJ\t \t K\tL\t \t \t\tM\t \t \tN\t \t \n\tO\t \t \t@\t \t \tP\n\tQ\t \t  \tR\t \t \tS\t8 8 8 9 8 6  5  , 2, T4 0 60 U4 232V502 W1 232X51232502 766 75 \t \r\t\t \t \tY\t \t \tZ\t \t \r\t[\t \t \t\\\t \t \t[\t \t \tR\t \t ]!\t \t \t^\t \t \t_\t \t \t`\t \t \ta\t \t \tb\t \t \n\tc\t \t \td\t \t \n\te\t \t \t\tQ\t \t \tf\t \t \tg\t \t \f\th\t \t \t@\t \t \ti\t \t \tj\t \t \tR\t \t \tk\t l2 mnmop0m\t \t \tq\t \t \t9\t \t \t9\t \t r!\t \t \t\ts\t \t \t\t9\t \t \t9\t \t \tt\t \t \t[\t \t \tR\t \t \t\t@\t \t \tb\t \t \tR\t \t \tu\t \t v!\t \t \tb\t \t \tg\t \t \tw\t \t \tx\t\t yz1ymnm{p1mnm|p0m\t \t }!\t \t \t~\t \t \t9\t \t \t[\t \t \t\te\t \t \t\t \t \t!\t \t \t@\t\t y7y1ymnmVp0m\t \t \tZ\t \t \t9\t \t \tR\t\t y1y 1 ", offset, result);
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
        int[] result = new int[131];
        byte offset = 0;
        zzUnpackAttribute("\t\t\'\t  \t\t\t  \b   ", offset, result);
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

    ElmColorLexer(Reader in) {
        this.zzLexicalState = 0;
        this.zzBuffer = "";
        this.zzAtBOL = true;
        this.states = new LinkedList();
        zzReader = in;
    }

    ElmColorLexer(InputStream in) {
        this((Reader) (new InputStreamReader(in)));
    }

    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[65536];
        int i = 0;
        int j = 0;

        while (i < 1262) {
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
                    return ElmTypes.OPERATOR;
                case 5:
                    return ElmTypes.IDENTIFIER;
                case 6:
                    return ElmTypes.NUMBER;
                case 7:
                    return ElmTypes.KEYWORD;
                case 8:
                    return ElmTypes.BUILTIN;
                case 9:
                    this.yypushstate(2);
                    this.yypushback(2);
                    return ElmTypes.COMMENT;
                case 10:
                    return ElmTypes.STRING;
                case 11:
                    this.yypopstate();
                    return ElmTypes.COMMENT;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
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
