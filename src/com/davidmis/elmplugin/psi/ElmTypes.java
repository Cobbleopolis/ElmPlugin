package com.davidmis.elmplugin.psi;

import com.davidmis.elmplugin.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface ElmTypes {

    IElementType ASSIGNMENT = new ElmElementType("ASSIGNMENT");
    IElementType COLOR_TYPES = new ElmElementType("COLOR_TYPES");
    IElementType DECLARATION = new ElmElementType("DECLARATION");
    IElementType DECLARATION_LHS = new ElmElementType("DECLARATION_LHS");
    IElementType EXPRESSION = new ElmElementType("EXPRESSION");
    IElementType FUNCTION_APPLICATION = new ElmElementType("FUNCTION_APPLICATION");
    IElementType IF_EX = new ElmElementType("IF_EX");
    IElementType IMPORT_STATEMENT = new ElmElementType("IMPORT_STATEMENT");
    IElementType LIBRARY_LIST = new ElmElementType("LIBRARY_LIST");
    IElementType LIBRARY_NAME = new ElmElementType("LIBRARY_NAME");
    IElementType PROPERTY = new ElmElementType("PROPERTY");
    IElementType RESERVED = new ElmElementType("RESERVED");
    IElementType SIMPLE_EX = new ElmElementType("SIMPLE_EX");
    IElementType STATEMENT = new ElmElementType("STATEMENT");
    IElementType ARROW = new ElmTokenType("ARROW");
    IElementType AS = new ElmTokenType("AS");
    IElementType BUILTIN = new ElmTokenType("BUILTIN");
    IElementType CASE = new ElmTokenType("CASE");
    IElementType COLON = new ElmTokenType("COLON");
    IElementType COMMENT = new ElmTokenType("COMMENT");
    IElementType CRLF = new ElmTokenType("CRLF");
    IElementType DATA = new ElmTokenType("DATA");
    IElementType DOT = new ElmTokenType("DOT");
    IElementType DOTDOT = new ElmTokenType("DOTDOT");
    IElementType ELSE = new ElmTokenType("ELSE");
    IElementType EQUALS = new ElmTokenType("EQUALS");
    IElementType EXPORT = new ElmTokenType("EXPORT");
    IElementType FOREIGN = new ElmTokenType("FOREIGN");
    IElementType HIDING = new ElmTokenType("HIDING");
    IElementType IDENTIFIER = new ElmTokenType("IDENTIFIER");
    IElementType IF = new ElmTokenType("IF");
    IElementType IMPORT = new ElmTokenType("IMPORT");
    IElementType IN = new ElmTokenType("IN");
    IElementType KEY = new ElmTokenType("KEY");
    IElementType KEYWORD = new ElmTokenType("KEYWORD");
    IElementType LET = new ElmTokenType("LET");
    IElementType LPAREN = new ElmTokenType("LPAREN");
    IElementType MODULE = new ElmTokenType("MODULE");
    IElementType NUMBER = new ElmTokenType("NUMBER");
    IElementType OF = new ElmTokenType("OF");
    IElementType OPEN = new ElmTokenType("OPEN");
    IElementType OPERATOR = new ElmTokenType("OPERATOR");
    IElementType RPAREN = new ElmTokenType("RPAREN");
    IElementType SEPARATOR = new ElmTokenType("SEPARATOR");
    IElementType STRING = new ElmTokenType("STRING");
    IElementType THEN = new ElmTokenType("THEN");
    IElementType TYPE = new ElmTokenType("TYPE");
    IElementType VALUE = new ElmTokenType("VALUE");
    IElementType WHERE = new ElmTokenType("WHERE");
    IElementType WHITESPACE = new ElmTokenType("WHITESPACE");
    IElementType SEMICOLON = new ElmTokenType("SEMICOLON");

    public static class Factory {

        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == ElmTypes.ASSIGNMENT) {
                return new ElmAssignmentImpl(node);
            } else if (type == ElmTypes.COLOR_TYPES) {
                return new ElmColorTypesImpl(node);
            } else if (type == ElmTypes.DECLARATION) {
                return new ElmDeclarationImpl(node);
            } else if (type == ElmTypes.DECLARATION_LHS) {
                return new ElmDeclarationLhsImpl(node);
            } else if (type == ElmTypes.EXPRESSION) {
                return new ElmExpressionImpl(node);
            } else if (type == ElmTypes.FUNCTION_APPLICATION) {
                return new ElmFunctionApplicationImpl(node);
            } else if (type == ElmTypes.IF_EX) {
                return new ElmIfExImpl(node);
            } else if (type == ElmTypes.IMPORT_STATEMENT) {
                return new ElmImportStatementImpl(node);
            } else if (type == ElmTypes.LIBRARY_LIST) {
                return new ElmLibraryListImpl(node);
            } else if (type == ElmTypes.LIBRARY_NAME) {
                return new ElmLibraryNameImpl(node);
            } else if (type == ElmTypes.PROPERTY) {
                return new ElmPropertyImpl(node);
            } else if (type == ElmTypes.RESERVED) {
                return new ElmReservedImpl(node);
            } else if (type == ElmTypes.SIMPLE_EX) {
                return new ElmSimpleExImpl(node);
            } else if (type == ElmTypes.STATEMENT) {
                return new ElmStatementImpl(node);
            } else {
                throw new AssertionError("Unknown element type: " + type);
            }
        }
    }
}
