package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmImportStatement;
import com.davidmis.elmplugin.psi.ElmLibraryName;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ElmImportStatementImpl extends ASTWrapperPsiElement implements ElmImportStatement {

    public ElmImportStatementImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmImportStatementImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitImportStatement(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @NotNull
    public ElmLibraryName getLibraryName() {
        ElmLibraryName var10000 = (ElmLibraryName) this.findNotNullChildByClass(ElmLibraryName.class);
        if (var10000 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/psi/impl/ElmImportStatementImpl", "getLibraryName"}));
        } else {
            return var10000;
        }
    }
}
