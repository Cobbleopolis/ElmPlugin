package com.davidmis.elmplugin.psi;

import com.davidmis.elmplugin.ElmLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ElmTokenType extends IElementType {

    public ElmTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ElmLanguage.INSTANCE);
        if (debugName == null)
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"debugName", "com/davidmis/elmplugin/psi/ElmTokenType", "<init>"}));
    }

    public String toString() {
        return "ElmTokenType." + super.toString();
    }
}
