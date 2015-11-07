package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmFunctionApplication;
import com.davidmis.elmplugin.psi.ElmSimpleEx;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElmSimpleExImpl extends ASTWrapperPsiElement implements ElmSimpleEx {

    public ElmSimpleExImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmSimpleExImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitSimpleEx(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @Nullable
    public ElmFunctionApplication getFunctionApplication() {
        return (ElmFunctionApplication) this.findChildByClass(ElmFunctionApplication.class);
    }
}
