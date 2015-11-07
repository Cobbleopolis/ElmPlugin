package com.davidmis.elmplugin;

import com.davidmis.elmplugin.parser.ElmParser;
import com.davidmis.elmplugin.psi.ElmFile;
import com.davidmis.elmplugin.psi.ElmTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class ElmParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(new IElementType[]{TokenType.WHITE_SPACE});
    public static final TokenSet COMMENTS = TokenSet.create(new IElementType[]{ElmTypes.COMMENT});
    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(ElmLanguage.class));


    @NotNull
    public Lexer createLexer(Project project) {
        FlexAdapter var10000 = new FlexAdapter(new ElmLexer((Reader) null));
        if (var10000 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "createLexer"}));
        } else {
            return var10000;
        }
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        if (WHITE_SPACES == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "getWhitespaceTokens"}));
        } else {
            return WHITE_SPACES;
        }
    }

    @NotNull
    public TokenSet getCommentTokens() {
        if (COMMENTS == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "getCommentTokens"}));
        } else {
            return COMMENTS;
        }
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        if (TokenSet.EMPTY == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "getStringLiteralElements"}));
        } else {
            return TokenSet.EMPTY;
        }
    }

    @NotNull
    public PsiParser createParser(Project project) {
        ElmParser parser = new ElmParser();
        if (parser == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "createParser"}));
        } else {
            return parser;
        }
    }

    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ElmFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        PsiElement elem = ElmTypes.Factory.createElement(node);
        if (elem == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmParserDefinition", "createElement"}));
        } else {
            return elem;
        }
    }

}
