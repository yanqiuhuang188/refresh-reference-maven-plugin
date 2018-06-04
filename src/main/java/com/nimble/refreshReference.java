package com.nimble;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * maven plugin
 */
@Mojo(name = "refreshReference")
public class refreshReference extends AbstractMojo {

    @Parameter
    private String[] paths;

    public void execute() {
        try {
            for (String item : paths) {

                Path path = Paths.get(item);
                if (Files.exists(path)) {
                    // Directory
                    if (Files.isDirectory(path)) {
                        FileUtils.deleteDirectory(path.toFile());
                    } else {
                        Files.deleteIfExists(path);
                    }
                    this.printLog("Ok : " + path.toString() + " had delete !");

                } else {
                    this.printLog("Warn : " + path.toString() + " is not exist !");
                }

            }
        } catch (IOException e) {
            this.printLog("Error, cause by " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    private void printLog(String str) {
        str = "****  " + str + "   ****";

        StringBuffer sb = new StringBuffer();
        for (int index = 0; index <= str.length(); index++) {
            sb.append("*");
        }

        System.out.println();
        System.out.println(sb.toString());
        System.out.println(str);
        System.out.println(sb.toString());
        System.out.println();
    }
}
