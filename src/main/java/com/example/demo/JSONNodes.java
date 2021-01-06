package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONNodes {

    JsonNode root;

    public JSONNodes(JsonNode root) {
        this.root = root;
    }

    public enum Paths {

        ACCESS_INFO,
        AUTHORS,
        BOOK,
        EPUB,
        IMAGE_LINKS,
        INDUSTRY_IDENTIFIER,
        PDF,
        READING_MODES,
        SALE_INFO,
        SEARCH_INFO,
        VOLUME_INFO

    }

    public JsonNode getPath(Paths path) {
        switch (path) {
            case VOLUME_INFO:
                return root.get("volumeInfo");
            case AUTHORS:
                return root.get("volumeInfo").get("authors");
            case INDUSTRY_IDENTIFIER:
                return root.get("volumeInfo").get("industryIdentifiers");
            case READING_MODES:
                return root.get("volumeInfo").get("readingModes");
            case IMAGE_LINKS:
                return root.get("volumeInfo").get("imageLinks");

            case SALE_INFO:
                return root.get("saleInfo");

            case ACCESS_INFO:
                return root.get("accessInfo");
            case EPUB:
                return root.get("accessInfo").get("epub");
            case PDF:
                return root.get("accessInfo").get("pdf");

            case SEARCH_INFO:
                return root.get("searchInfo");

            case BOOK:
                return root;

            default:
                throw new IllegalArgumentException("Unknown JSON element.");

        }

    }
}
