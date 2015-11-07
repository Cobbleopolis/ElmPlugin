package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElmIfEx extends PsiElement {

    @NotNull
    List getExpressionList();
}
