package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ElmExpression extends PsiElement {

    @Nullable
    ElmIfEx getIfEx();

    @Nullable
    ElmSimpleEx getSimpleEx();
}
