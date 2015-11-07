package com.davidmis.elmplugin;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ElmSettingsConfigurable implements Configurable {

    private ElmSettingsComponent component;


    @Nls
    public String getDisplayName() {
        return "Elm language";
    }

    @Nullable
    public String getHelpTopic() {
        return "Elm language";
    }

    @Nullable
    public JComponent createComponent() {
        if (this.component == null) {
            this.component = new ElmSettingsComponent();
        }

        return this.component.mainPanel;
    }

    public boolean isModified() {
        return true;
    }

    public void apply() throws ConfigurationException {
        if (this.component != null) {
            String newPath = this.component.pathField.getText() == null ? "" : this.component.pathField.getText();
            ElmPersister.instance.setPathToElmMake(newPath);
            System.out.println("Path to elm-make: " + newPath);
            Boolean errorCheckingEnabled = Boolean.valueOf(this.component.enableErrorCheckingCheckBox.isSelected());
            ElmPersister.instance.setEnableErrorChecking(errorCheckingEnabled.booleanValue());
            System.out.println("Error checking enabled " + errorCheckingEnabled);
        }
    }

    public void reset() {
    }

    public void disposeUIResources() {
    }
}
