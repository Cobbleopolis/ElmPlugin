package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmExpression;
import com.davidmis.elmplugin.psi.ElmIfEx;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElmIfExImpl extends ASTWrapperPsiElement implements ElmIfEx {

    public ElmIfExImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmIfExImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitIfEx(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @NotNull
    public List getExpressionList() {
        List var10000 = PsiTreeUtil.getChildrenOfTypeAsList(this, ElmExpression.class);
        if (var10000 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/psi/impl/ElmIfExImpl", "getExpressionList"}));
        } else {
            return var10000;
        }
    }
}
