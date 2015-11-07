package com.davidmis.elmplugin;

import com.davidmis.elmplugin.psi.ElmTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

public class ElmSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("ELM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("ELM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("ELM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("ELM_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("ELM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey OPERATOR = TextAttributesKey.createTextAttributesKey("ELM_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BUILTIN = TextAttributesKey.createTextAttributesKey("ELM_BUILTIN", DefaultLanguageHighlighterColors.CONSTANT);
//    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("ELM_BAD_CHARACTER", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey SEMICOLON = TextAttributesKey.createTextAttributesKey("SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("ELM_BAD_CHARACTER", new TextAttributes(Color.RED, (Color) null, (Color) null, (EffectType) null, 1));
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] BUILTIN_KEYS = new TextAttributesKey[]{BUILTIN};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @NotNull
    public Lexer getHighlightingLexer() {
        FlexAdapter flexAdapter = new FlexAdapter(new ElmColorLexer((Reader) null));
        if (flexAdapter == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getHighlightingLexer"}));
        } else {
            return flexAdapter;
        }
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ElmTypes.COMMENT)) {
            if (COMMENT_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return COMMENT_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.SEMICOLON)) {
            return SEMICOLON_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            if (BAD_CHAR_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return BAD_CHAR_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.NUMBER)) {
            if (NUMBER_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return NUMBER_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.BUILTIN)) {
            if (BUILTIN_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return BUILTIN_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.STRING)) {
            if (STRING_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return STRING_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.OPERATOR)) {
            if (OPERATOR_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return OPERATOR_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.KEYWORD)) {
            if (KEYWORD_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return KEYWORD_KEYS;
            }
        } else if (tokenType.equals(ElmTypes.IDENTIFIER)) {
            if (IDENTIFIER_KEYS == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
            } else {
                return IDENTIFIER_KEYS;
            }
        } else if (EMPTY_KEYS == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighter", "getTokenHighlights"}));
        } else {
            return EMPTY_KEYS;
        }
    }

}
