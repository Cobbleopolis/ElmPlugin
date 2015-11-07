package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmLibraryList;
import com.davidmis.elmplugin.psi.ElmLibraryName;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElmLibraryNameImpl extends ASTWrapperPsiElement implements ElmLibraryName {

    public ElmLibraryNameImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmLibraryNameImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitLibraryName(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @Nullable
    public ElmLibraryList getLibraryList() {
        return (ElmLibraryList) this.findChildByClass(ElmLibraryList.class);
    }
}
