package com.nimble;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;


/**
 * maven plugin
 */
@Mojo(name = "refreshReference")
public class refreshReference extends AbstractMojo {

    @Parameter
    private String[] paths;

    public void execute() {
        for(String path : paths){
            System.out.println("path = " + path);
        }
    }
}
