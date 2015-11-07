package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmExpression;
import com.davidmis.elmplugin.psi.ElmIfEx;
import com.davidmis.elmplugin.psi.ElmSimpleEx;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElmExpressionImpl extends ASTWrapperPsiElement implements ElmExpression {

    public ElmExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmExpressionImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitExpression(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @Nullable
    public ElmIfEx getIfEx() {
        return (ElmIfEx) this.findChildByClass(ElmIfEx.class);
    }

    @Nullable
    public ElmSimpleEx getSimpleEx() {
        return (ElmSimpleEx) this.findChildByClass(ElmSimpleEx.class);
    }
}
