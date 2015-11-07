package com.davidmis.elmplugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications.Bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElmChecker {

    public static ElmChecker instance = new ElmChecker();
    private boolean errorShownOnce = false;


    public String getCompilerOutput(String filename) {
        return this.getCompilerOutput(ElmPersister.instance.getPathToElmMake(), filename);
    }

    private String getCompilerOutput(String pathToElm, String filename) {
        try {
            ProcessBuilder e = new ProcessBuilder(new String[]{pathToElm, filename, "--yes"});
            Process process = e.start();
            process.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder output = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                output.append(line + "\n");
            }

            return output.toString();
        } catch (IOException var8) {
            if (!this.errorShownOnce) {
                this.errorShownOnce = true;
                Bus.notify(new Notification("External Executables Critical Failure", "Error running elm-make", "Could not run elm-make. Error checking disabled. Is the path configured in Settings > Other Settings > Elm Language?", NotificationType.ERROR));
            }

            var8.printStackTrace();
        } catch (InterruptedException var9) {
            var9.printStackTrace();
        }

        return "";
    }

}
