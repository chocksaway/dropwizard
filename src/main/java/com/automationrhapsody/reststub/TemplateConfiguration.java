package com.automationrhapsody.reststub;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by harshvardhan on 19/07/18.
 */
public class TemplateConfiguration{

    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);


    public static Configuration getConfiguration() {
        try {
            configuration.setDirectoryForTemplateLoading(new File("templates"));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }
}