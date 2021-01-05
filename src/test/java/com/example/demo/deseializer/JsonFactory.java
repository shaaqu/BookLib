package com.example.demo.deseializer;

import org.json.JSONObject;

public class JsonFactory {

    public enum JsonEnum {
        WITHOUT_ASSERT,
        FULL,
        WITH_2_AUTHORS,
        ACCESS_INFO,
        AUTHOR,
        EBOOK,
        EPUB,
        IMAGE_LINKS,
        INDUSTRY_IDENTIFIER,
        PDF,
        READING_MODEL,
        SALE_INFO,
        SEARCH_INFO,
        VOLUME_INFO
    }

    public static String jsonFactory(JsonEnum aJsonEnum) {
        switch (aJsonEnum){
            case WITHOUT_ASSERT:
                return new JSONObject().toString();

            case FULL:
                return new JSONObject().toString();

            case WITH_2_AUTHORS:
                return new JSONObject().toString();

            case ACCESS_INFO:
                return new JSONObject().toString();

            case AUTHOR:
                return new JSONObject().toString();

            case EBOOK:
                return new JSONObject().toString();

            case EPUB:
                return new JSONObject().toString();

            case IMAGE_LINKS:
                return new JSONObject().toString();

            case INDUSTRY_IDENTIFIER:
                return new JSONObject().toString();

            case PDF:
                return new JSONObject().toString();

            case READING_MODEL:
                return new JSONObject().toString();

            case SALE_INFO:
                return new JSONObject().toString();

            case SEARCH_INFO:
                return new JSONObject().toString();

            case VOLUME_INFO:
                return new JSONObject().toString();

            default:
                throw new IllegalArgumentException("Unknown JSON type.");
        }
    }
}
