package com.davidmis.elmplugin.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ElmVisitor extends PsiElementVisitor {

    public void visitAssignment(@NotNull ElmAssignment o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitAssignment"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitColorTypes(@NotNull ElmColorTypes o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitColorTypes"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitDeclaration(@NotNull ElmDeclaration o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitDeclaration"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitDeclarationLhs(@NotNull ElmDeclarationLhs o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitDeclarationLhs"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitExpression(@NotNull ElmExpression o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitExpression"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitFunctionApplication(@NotNull ElmFunctionApplication o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitFunctionApplication"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitIfEx(@NotNull ElmIfEx o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitIfEx"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitImportStatement(@NotNull ElmImportStatement o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitImportStatement"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitLibraryList(@NotNull ElmLibraryList o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitLibraryList"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitLibraryName(@NotNull ElmLibraryName o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitLibraryName"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitProperty(@NotNull ElmProperty o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitProperty"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitReserved(@NotNull ElmReserved o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitReserved"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitSimpleEx(@NotNull ElmSimpleEx o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitSimpleEx"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitStatement(@NotNull ElmStatement o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitStatement"}));
        } else {
            this.visitPsiElement(o);
        }
    }

    public void visitPsiElement(@NotNull PsiElement o) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", new Object[]{"o", "com/davidmis/elmplugin/psi/ElmVisitor", "visitPsiElement"}));
        } else {
            this.visitElement(o);
        }
    }
}
