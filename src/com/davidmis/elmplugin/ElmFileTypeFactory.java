package com.davidmis.elmplugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ElmFileTypeFactory extends FileTypeFactory {

    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        if (fileTypeConsumer == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"fileTypeConsumer", "com/davidmis/elmplugin/ElmFileTypeFactory", "createFileTypes"}));
        } else {
            fileTypeConsumer.consume(ElmFileType.INSTANCE, "elm");
        }
    }
}
