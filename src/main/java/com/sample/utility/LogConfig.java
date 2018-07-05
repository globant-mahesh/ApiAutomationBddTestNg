package com.sample.utility;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogConfig implements Configurable {

    @Override
    public Logger getLogger() {
        Logger logger = LoggerFactory.getLogger(getClass());
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        return logger;
    }
}
