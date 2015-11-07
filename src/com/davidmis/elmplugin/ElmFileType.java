package com.davidmis.elmplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ElmFileType extends LanguageFileType {

    public static final ElmFileType INSTANCE = new ElmFileType();


    private ElmFileType() {
        super(ElmLanguage.INSTANCE);
    }

    @NotNull
    public String getName() {
        if ("Elm file" == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmFileType", "getName"}));
        } else {
            return "Elm file";
        }
    }

    @NotNull
    public String getDescription() {
        if ("Elm language file" == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmFileType", "getDescription"}));
        } else {
            return "Elm language file";
        }
    }

    @NotNull
    public String getDefaultExtension() {
        if ("elm" == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmFileType", "getDefaultExtension"}));
        } else {
            return "elm";
        }
    }

    @Nullable
    public Icon getIcon() {
        return ElmIcons.FILE;
    }

}
