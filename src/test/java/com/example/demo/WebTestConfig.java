package com.example.demo;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;
import java.util.Properties;

public class WebTestConfig {

    private WebTestConfig(){}

    public static SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver =
                new SimpleMappingExceptionResolver();

        Properties exceptionMappings = new Properties();

        exceptionMappings.put("java.lang.RuntimeException", "error/error");
        exceptionMappings.put("java.lang.Exception", "error/error");

        exceptionResolver.setExceptionMappings(exceptionMappings);

        Properties statusCodes = new Properties();

        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");

        exceptionResolver.setStatusCodes(statusCodes);

        return exceptionResolver;
    }

    public static LocaleResolver fixedLocaleResolver() {
        return new FixedLocaleResolver(Locale.ENGLISH);
    }
}
