package com.davidmis.elmplugin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

public class ElmSettingsComponent {

    public JPanel mainPanel;
    public JLabel pathLabel;
    public JTextField pathField;
    public JCheckBox enableErrorCheckingCheckBox;


    public ElmSettingsComponent() {
        this.$$$setupUI$$$();
    }

    private void createUIComponents() {
        this.pathField = new JTextField(ElmPersister.instance.getPathToElmMake());
        this.enableErrorCheckingCheckBox = new JCheckBox("Enable error checking", ElmPersister.instance.getEnableErrorChecking());
    }

    private void $$$setupUI$$$() {
        this.createUIComponents();
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.pathLabel = new JLabel();
        this.pathLabel.setText("Path to elm-make:");
        this.mainPanel.add(this.pathLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, (Dimension) null, (Dimension) null, (Dimension) null, 0, false));
        Spacer spacer1 = new Spacer();
        this.mainPanel.add(spacer1, new GridConstraints(2, 0, 1, 2, 0, 2, 1, 4, (Dimension) null, (Dimension) null, (Dimension) null, 0, false));
        this.mainPanel.add(this.pathField, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, (Dimension) null, new Dimension(150, -1), (Dimension) null, 0, false));
        this.enableErrorCheckingCheckBox.setText("Enable error checking");
        this.mainPanel.add(this.enableErrorCheckingCheckBox, new GridConstraints(1, 0, 1, 1, 8, 0, 3, 0, (Dimension) null, (Dimension) null, (Dimension) null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.mainPanel;
    }
}
