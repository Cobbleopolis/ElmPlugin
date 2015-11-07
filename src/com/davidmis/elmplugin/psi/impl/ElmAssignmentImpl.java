package com.davidmis.elmplugin.psi.impl;

import com.davidmis.elmplugin.psi.ElmAssignment;
import com.davidmis.elmplugin.psi.ElmExpression;
import com.davidmis.elmplugin.psi.ElmVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ElmAssignmentImpl extends ASTWrapperPsiElement implements ElmAssignment {

    public ElmAssignmentImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"visitor", "com/davidmis/elmplugin/psi/impl/ElmAssignmentImpl", "accept"}));
        } else {
            if (visitor instanceof ElmVisitor) {
                ((ElmVisitor) visitor).visitAssignment(this);
            } else {
                super.accept(visitor);
            }

        }
    }

    @NotNull
    public ElmExpression getExpression() {
        ElmExpression var10000 = (ElmExpression) this.findNotNullChildByClass(ElmExpression.class);
        if (var10000 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/psi/impl/ElmAssignmentImpl", "getExpression"}));
        } else {
            return var10000;
        }
    }
}
