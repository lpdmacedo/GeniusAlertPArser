package com.meli.ba.utils;

import com.ibatis.common.jdbc.ScriptRunner;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lpdmacedo on 12/7/16.
 */

@Component("schemaLoader")
public class SchemaLoader {

    private final static Logger LOGGER = Logger.getLogger(SchemaLoader.class.getName());

    @Autowired private DataSource dataSource;

    @PostConstruct
    void init() {
        String aSQLScriptFilePath = FileUtils.getFile("schema.sql").getAbsolutePath();


        try {
            ScriptRunner sr = new ScriptRunner(dataSource.getConnection(), false, false);
            Reader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("database/schema.sql")));
            sr.runScript(reader);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to Execute" + aSQLScriptFilePath + " The error is " + e.getMessage());
        }
    }
}
