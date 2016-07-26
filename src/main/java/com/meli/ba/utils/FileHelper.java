package com.meli.ba.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Component("fileHelper")
@Scope("singleton")
public class FileHelper {
    private File script;

    private final static Logger LOGGER = Logger.getLogger(FileHelper.class.getName());

    @PostConstruct
    void init() {
        script = new File(System.getProperty("java.io.tmpdir") + "data.sql");
        try {
            script.delete();
            script.createNewFile();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to create script file");
        }
    }

    /**
     * Read File To String
     * @param path
     * @return String
     */
    public String readFile(String path) {
        String data = null;
        try {
            data = FileUtils.readFileToString(new File(path), "UTF-8");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read file: " + path);
        }
        return data;
    }

    /**
     * Scan dir to find files .json
     * @param rootPath
     * @return File paths
     */
    public File[] scanDir(String rootPath) {
        LOGGER.log(Level.INFO, "[Root Path] " + rootPath);
        return new File(rootPath).listFiles();
    }

    public void setToScript(String sql) {
        try {
            FileUtils.write(script, sql, true);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to write sql data");
        }
    }
}
