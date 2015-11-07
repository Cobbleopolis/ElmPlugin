package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ElmStatement extends PsiElement {

    @Nullable
    ElmAssignment getAssignment();

    @Nullable
    ElmImportStatement getImportStatement();
}
