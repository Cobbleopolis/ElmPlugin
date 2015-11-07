package com.davidmis.elmplugin;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ElmSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

    @NotNull
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        ElmSyntaxHighlighter syntaxHighlighter = new ElmSyntaxHighlighter();
        if (syntaxHighlighter == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"com/davidmis/elmplugin/ElmSyntaxHighlighterFactory", "getSyntaxHighlighter"}));
        } else {
            return syntaxHighlighter;
        }
    }
}
