package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElmDeclarationLhs extends PsiElement {

    @NotNull
    List getDeclarationLhsList();
}
