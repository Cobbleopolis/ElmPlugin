package com.davidmis.elmplugin.parser;

import com.davidmis.elmplugin.psi.ElmTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.lang.parser.GeneratedParserUtilBase.Parser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public class ElmParser implements PsiParser {

    public ASTNode parse(IElementType t, PsiBuilder b) {
        this.parseLight(t, b);
        return b.getTreeBuilt();
    }

    public void parseLight(IElementType t, PsiBuilder b) {
        b = GeneratedParserUtilBase.adapt_builder_(t, b, this, (TokenSet[]) null);
        Marker m = GeneratedParserUtilBase.enter_section_(b, 0, 1, (String) null);
        boolean r;
        if (t == ElmTypes.ASSIGNMENT) {
            r = assignment(b, 0);
        } else if (t == ElmTypes.COLOR_TYPES) {
            r = color_types(b, 0);
        } else if (t == ElmTypes.DECLARATION) {
            r = declaration(b, 0);
        } else if (t == ElmTypes.DECLARATION_LHS) {
            r = declaration_lhs(b, 0);
        } else if (t == ElmTypes.EXPRESSION) {
            r = expression(b, 0);
        } else if (t == ElmTypes.FUNCTION_APPLICATION) {
            r = function_application(b, 0);
        } else if (t == ElmTypes.IF_EX) {
            r = if_ex(b, 0);
        } else if (t == ElmTypes.IMPORT_STATEMENT) {
            r = import_statement(b, 0);
        } else if (t == ElmTypes.LIBRARY_LIST) {
            r = library_list(b, 0);
        } else if (t == ElmTypes.LIBRARY_NAME) {
            r = library_name(b, 0);
        } else if (t == ElmTypes.PROPERTY) {
            r = property(b, 0);
        } else if (t == ElmTypes.RESERVED) {
            r = reserved(b, 0);
        } else if (t == ElmTypes.SIMPLE_EX) {
            r = simple_ex(b, 0);
        } else if (t == ElmTypes.STATEMENT) {
            r = statement(b, 0);
        } else if (t == ElmTypes.SEMICOLON) {
            r = statement(b, 0);
        } else {
            r = this.parse_root_(t, b, 0);
        }

        GeneratedParserUtilBase.exit_section_(b, 0, m, t, r, true, GeneratedParserUtilBase.TRUE_CONDITION);
    }

    protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
        return elmFile(b, l + 1);
    }

    public static boolean assignment(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "assignment")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IDENTIFIER)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            r = r && assignment_1(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.EQUALS);
            r = r && assignment_3(b, l + 1);
            r = r && expression(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.ASSIGNMENT, r);
            return r;
        }
    }

    private static boolean assignment_1(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "assignment_1")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    private static boolean assignment_3(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "assignment_3")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    public static boolean color_types(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "color_types")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<color types>");
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.BUILTIN);
            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.KEYWORD);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.OPERATOR);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.COLOR_TYPES, r, false, (Parser) null);
            return r;
        }
    }

    public static boolean declaration(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IDENTIFIER)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            r = r && declaration_1(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.COLON);
            r = r && declaration_3(b, l + 1);
            r = r && declaration_lhs(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.DECLARATION, r);
            return r;
        }
    }

    private static boolean declaration_1(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_1")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    private static boolean declaration_3(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_3")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    public static boolean declaration_lhs(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_lhs")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IDENTIFIER)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            r = r && declaration_lhs_1(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.DECLARATION_LHS, r);
            return r;
        }
    }

    private static boolean declaration_lhs_1(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_lhs_1")) {
            return false;
        } else {
            for (int c = GeneratedParserUtilBase.current_position_(b); declaration_lhs_1_0(b, l + 1) && GeneratedParserUtilBase.empty_element_parsed_guard_(b, "declaration_lhs_1", c); c = GeneratedParserUtilBase.current_position_(b)) {
                ;
            }

            return true;
        }
    }

    private static boolean declaration_lhs_1_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_lhs_1_0")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = declaration_lhs_1_0_0(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.ARROW);
            r = r && declaration_lhs_1_0_2(b, l + 1);
            r = r && declaration_lhs(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, (IElementType) null, r);
            return r;
        }
    }

    private static boolean declaration_lhs_1_0_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_lhs_1_0_0")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    private static boolean declaration_lhs_1_0_2(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "declaration_lhs_1_0_2")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    static boolean elmFile(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "elmFile")) {
            return false;
        } else {
            for (int c = GeneratedParserUtilBase.current_position_(b); elmFile_0(b, l + 1) && GeneratedParserUtilBase.empty_element_parsed_guard_(b, "elmFile", c); c = GeneratedParserUtilBase.current_position_(b)) {
                ;
            }

            return true;
        }
    }

    private static boolean elmFile_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "elmFile_0")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            if (!r) {
                r = declaration(b, l + 1);
            }

            if (!r) {
                r = statement(b, l + 1);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.COMMENT);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.CRLF);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            }

            GeneratedParserUtilBase.exit_section_(b, m, (IElementType) null, r);
            return r;
        }
    }

    public static boolean expression(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "expression")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<expression>");
            boolean r = if_ex(b, l + 1);
            if (!r) {
                r = simple_ex(b, l + 1);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.EXPRESSION, r, false, (Parser) null);
            return r;
        }
    }

    public static boolean function_application(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "function_application")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IDENTIFIER)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.IDENTIFIER, ElmTypes.WHITESPACE});
            r = r && function_application_2(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.FUNCTION_APPLICATION, r);
            return r;
        }
    }

    private static boolean function_application_2(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "function_application_2")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.STRING);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.NUMBER);
            }

            if (!r) {
                r = function_application(b, l + 1);
            }

            GeneratedParserUtilBase.exit_section_(b, m, (IElementType) null, r);
            return r;
        }
    }

    public static boolean if_ex(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "if_ex")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IF)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.IF, ElmTypes.WHITESPACE});
            r = r && expression(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.WHITESPACE, ElmTypes.THEN, ElmTypes.WHITESPACE});
            r = r && expression(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.WHITESPACE, ElmTypes.ELSE, ElmTypes.WHITESPACE});
            r = r && expression(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.IF_EX, r);
            return r;
        }
    }

    public static boolean import_statement(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "import_statement")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IMPORT)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.IMPORT, ElmTypes.WHITESPACE});
            r = r && library_name(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.IMPORT_STATEMENT, r);
            return r;
        }
    }

    public static boolean library_list(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_list")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.LPAREN)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.LPAREN);
            r = r && library_list_1(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.DOTDOT);
            r = r && library_list_3(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.RPAREN);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.LIBRARY_LIST, r);
            return r;
        }
    }

    private static boolean library_list_1(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_list_1")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    private static boolean library_list_3(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_list_3")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    public static boolean library_name(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_name")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, ElmTypes.IDENTIFIER)) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            r = r && library_name_1(b, l + 1);
            r = r && library_name_2(b, l + 1);
            r = r && library_name_3(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, ElmTypes.LIBRARY_NAME, r);
            return r;
        }
    }

    private static boolean library_name_1(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_name_1")) {
            return false;
        } else {
            for (int c = GeneratedParserUtilBase.current_position_(b); library_name_1_0(b, l + 1) && GeneratedParserUtilBase.empty_element_parsed_guard_(b, "library_name_1", c); c = GeneratedParserUtilBase.current_position_(b)) {
                ;
            }

            return true;
        }
    }

    private static boolean library_name_1_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_name_1_0")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = GeneratedParserUtilBase.consumeTokens(b, 0, new IElementType[]{ElmTypes.DOT, ElmTypes.IDENTIFIER});
            GeneratedParserUtilBase.exit_section_(b, m, (IElementType) null, r);
            return r;
        }
    }

    private static boolean library_name_2(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_name_2")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHITESPACE);
            return true;
        }
    }

    private static boolean library_name_3(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "library_name_3")) {
            return false;
        } else {
            library_list(b, l + 1);
            return true;
        }
    }

    public static boolean property(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "property")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, "<property>", new IElementType[]{ElmTypes.KEY, ElmTypes.SEPARATOR})) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<property>");
            boolean r = property_0(b, l + 1);
            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.KEY);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.PROPERTY, r, false, (Parser) null);
            return r;
        }
    }

    private static boolean property_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "property_0")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b);
            boolean r = property_0_0(b, l + 1);
            r = r && GeneratedParserUtilBase.consumeToken(b, ElmTypes.SEPARATOR);
            r = r && property_0_2(b, l + 1);
            GeneratedParserUtilBase.exit_section_(b, m, (IElementType) null, r);
            return r;
        }
    }

    private static boolean property_0_0(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "property_0_0")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.KEY);
            return true;
        }
    }

    private static boolean property_0_2(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "property_0_2")) {
            return false;
        } else {
            GeneratedParserUtilBase.consumeToken(b, ElmTypes.VALUE);
            return true;
        }
    }

    public static boolean reserved(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "reserved")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<reserved>");
            boolean r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IF);
            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.THEN);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.ELSE);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.CASE);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.OF);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.LET);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IN);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.DATA);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.TYPE);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.MODULE);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.WHERE);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IMPORT);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.AS);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.HIDING);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.OPEN);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.EXPORT);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.FOREIGN);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.RESERVED, r, false, (Parser) null);
            return r;
        }
    }

    public static boolean simple_ex(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "simple_ex")) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<simple ex>");
            boolean r = function_application(b, l + 1);
            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.IDENTIFIER);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.NUMBER);
            }

            if (!r) {
                r = GeneratedParserUtilBase.consumeToken(b, ElmTypes.STRING);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.SIMPLE_EX, r, false, (Parser) null);
            return r;
        }
    }

    public static boolean statement(PsiBuilder b, int l) {
        if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement")) {
            return false;
        } else if (!GeneratedParserUtilBase.nextTokenIs(b, "<statement>", new IElementType[]{ElmTypes.IDENTIFIER, ElmTypes.IMPORT})) {
            return false;
        } else {
            Marker m = GeneratedParserUtilBase.enter_section_(b, l, 0, "<statement>");
            boolean r = assignment(b, l + 1);
            if (!r) {
                r = import_statement(b, l + 1);
            }

            GeneratedParserUtilBase.exit_section_(b, l, m, ElmTypes.STATEMENT, r, false, (Parser) null);
            return r;
        }
    }
}
