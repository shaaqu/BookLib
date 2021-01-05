package com.example.demo.deseializer;

import com.example.demo.entities.Book;
import com.example.demo.services.BookJsonModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookItemDeserializerTest {

    ObjectMapper objectMapper;
    String jsonStr;

    @Before
    void loadJSON() {
        jsonStr = JSONReader.readJSON("testJson.json");
    }

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new BookJsonModule());
    }

    @Test
    void bookDeserializeWithoutAssertions() throws JsonProcessingException {
        Book book = objectMapper.readValue(jsonStr, Book.class);


    }

}