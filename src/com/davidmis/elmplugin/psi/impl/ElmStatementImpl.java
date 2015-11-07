package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmAssignment;
import com.davidmis.elmplugin.psi.ElmImportStatement;
import com.davidmis.elmplugin.psi.ElmStatement;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElmStatementImpl extends ASTWrapperPsiElement implements ElmStatement {

    public ElmStatementImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmStatementImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitStatement(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @Nullable
    public ElmAssignment getAssignment() {
        return (ElmAssignment) this.findChildByClass(ElmAssignment.class);
    }

    @Nullable
    public ElmImportStatement getImportStatement() {
        return (ElmImportStatement) this.findChildByClass(ElmImportStatement.class);
    }
}
