package com.davidmis.elmplugin.psi;

import com.davidmis.elmplugin.ElmFileType;
import com.davidmis.elmplugin.ElmLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ElmFile extends PsiFileBase {

    public ElmFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ElmLanguage.INSTANCE);
        if (viewProvider == null)
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"viewProvider", "com/davidmis/elmplugin/psi/ElmFile", "<init>"}));
    }

    @NotNull
    public FileType getFileType() {
        if (ElmFileType.INSTANCE == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/psi/ElmFile", "getFileType"}));
        } else {
            return ElmFileType.INSTANCE;
        }
    }

    public String toString() {
        return "Elm Language File";
    }

    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
