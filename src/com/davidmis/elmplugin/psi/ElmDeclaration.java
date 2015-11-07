package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface ElmDeclaration extends PsiElement {

    @NotNull
    ElmDeclarationLhs getDeclarationLhs();
}
