package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmLibraryList;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ElmLibraryListImpl extends ASTWrapperPsiElement implements ElmLibraryList {

    public ElmLibraryListImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmLibraryListImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitLibraryList(this);
            } else {
                super.accept(visitor);
            }

        }
    }
}
