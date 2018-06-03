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
                if(Files.exists(path)){
                    // Directory
                    if (Files.isDirectory(path)) {
                        FileUtils.deleteDirectory(path.toFile());
                    } else {
                        Files.deleteIfExists(path);
                    }
                    System.out.println("Ok : " + path.toString() + " had delete !");
                }else {
                    System.out.println("Warn : " + path.toString() + " is not exist !");
                }

            }
        } catch (IOException e) {
            System.out.println("Error, cause by " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}
