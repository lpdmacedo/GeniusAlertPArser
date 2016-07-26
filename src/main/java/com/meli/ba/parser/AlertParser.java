package com.meli.ba.parser;

import com.meli.ba.utils.AlertMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class AlertParser {

    private final static Logger LOGGER = Logger.getLogger(AlertParser.class.getName());

    public static void main( String[] args ) {
        Assert.hasText(args[0].toString());
        LOGGER.log(Level.INFO, "[Root Path] " + args[0].toString());
        String folder = args[0].toString();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/Application-Context.xml");
        AlertMapper alertMapper = (AlertMapper) context.getBean("alertMapper");
        alertMapper.parser(folder);
    }
}
