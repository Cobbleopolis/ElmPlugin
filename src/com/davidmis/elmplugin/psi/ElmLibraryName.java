package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ElmLibraryName extends PsiElement {

    @Nullable
    ElmLibraryList getLibraryList();
}
