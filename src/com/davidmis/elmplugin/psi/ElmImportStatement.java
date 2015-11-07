package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface ElmImportStatement extends PsiElement {

    @NotNull
    ElmLibraryName getLibraryName();
}
