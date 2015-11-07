package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmDeclaration;
import com.davidmis.elmplugin.psi.ElmDeclarationLhs;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ElmDeclarationImpl extends ASTWrapperPsiElement implements ElmDeclaration {

    public ElmDeclarationImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmDeclarationImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitDeclaration(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @NotNull
    public ElmDeclarationLhs getDeclarationLhs() {
        ElmDeclarationLhs var10000 = (ElmDeclarationLhs) this.findNotNullChildByClass(ElmDeclarationLhs.class);
        if (var10000 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/psi/impl/ElmDeclarationImpl", "getDeclarationLhs"}));
        } else {
            return var10000;
        }
    }
}
