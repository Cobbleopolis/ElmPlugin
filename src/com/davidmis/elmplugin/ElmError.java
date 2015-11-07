package com.davidmis.elmplugin;

import com.intellij.openapi.editor.Document;

public class ElmError {

    private int line;
    private int startCol;
    private int endCol;
    private String message;
    private int startIndex;
    private int endIndex;


    public ElmError(int line, int startCol, int endCol, String message, Document document) {
        this.line = line;
        this.startCol = startCol;
        this.endCol = endCol;
        this.message = message;
        this.setIndecis(document);
    }

    public ElmError(int startIndex, int endIndex, String message) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.message = message;
    }

    public int getLine() {
        return this.line;
    }

    public int getStartCol() {
        return this.startCol;
    }

    public int getEndCol() {
        return this.endCol;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    private void setStartIndex(Document document) {
        this.startIndex = document.getLineStartOffset(this.line) + this.startCol;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    private void setEndIndex(Document document) {
        this.endIndex = document.getLineStartOffset(this.line) + this.endCol;
    }

    private void setIndecis(Document document) {
        this.setStartIndex(document);
        this.setEndIndex(document);
    }
}
