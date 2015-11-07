package com.davidmis.elmplugin;

import com.intellij.ide.util.PropertiesComponent;

public class ElmPersister {

    public static ElmPersister instance = new ElmPersister();
    private String pathToElmMake;
    private String enableErrorChecking;


    public String getPathToElmMake() {
        if (this.pathToElmMake == null) {
            this.pathToElmMake = PropertiesComponent.getInstance().getValue("com.davidmis.elmplugin.pathToElmMake", "elm-make");
        }

        return this.pathToElmMake;
    }

    public void setPathToElmMake(String path) {
        this.pathToElmMake = path;
        PropertiesComponent.getInstance().setValue("com.davidmis.elmplugin.pathToElmMake", this.pathToElmMake);
    }

    public boolean getEnableErrorChecking() {
        if (this.enableErrorChecking == null) {
            this.enableErrorChecking = PropertiesComponent.getInstance().getValue("com.davidmis.elmplugin.enableErrorChecking", "T");
        }

        return this.enableErrorChecking.equalsIgnoreCase("T");
    }

    public void setEnableErrorChecking(boolean enabled) {
        this.enableErrorChecking = enabled ? "T" : "F";
        PropertiesComponent.getInstance().setValue("com.davidmis.elmplugin.enableErrorChecking", this.enableErrorChecking);
    }

}
