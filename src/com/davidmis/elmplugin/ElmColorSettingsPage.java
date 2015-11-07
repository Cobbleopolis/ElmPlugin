package com.davidmis.elmplugin;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ElmColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", ElmSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad Character", ElmSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("Operators", ElmSyntaxHighlighter.OPERATOR)
    };


    @Nullable
    public Icon getIcon() {
        return ElmIcons.FILE;
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        ElmSyntaxHighlighter syntaxHighlighter = new ElmSyntaxHighlighter();
        if (syntaxHighlighter == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmColorSettingsPage", "getHighlighter"}));
        } else {
            return syntaxHighlighter;
        }
    }

    @NotNull
    public String getDemoText() {
        if ("import Graphics.Element (..) \nimport Text (..) \n\n\n--Simple example program\n\nmain : Element\nmain = plainText \"Hello, World!\"" == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmColorSettingsPage", "getDemoText"}));
        } else {
            return "import Graphics.Element (..) \nimport Text (..) \n\n\n--Simple example program\n\nmain : Element\nmain = plainText \"Hello, World!\"";
        }
    }

    @Nullable
    public Map getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        if (DESCRIPTORS == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmColorSettingsPage", "getAttributeDescriptors"}));
        } else {
            return DESCRIPTORS;
        }
    }

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        if (ColorDescriptor.EMPTY_ARRAY == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmColorSettingsPage", "getColorDescriptors"}));
        } else {
            return ColorDescriptor.EMPTY_ARRAY;
        }
    }

    @NotNull
    public String getDisplayName() {
        if ("Elm" == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmColorSettingsPage", "getDisplayName"}));
        } else {
            return "Elm";
        }
    }

}
