package com.example.demo.deseializer;

import com.example.demo.BookItemDeserializer;
import com.example.demo.entities.AccessInfo;
import com.example.demo.entities.Book;
import com.example.demo.services.BookJsonModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.json.*;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class BookItemDeserializerTest {

    ObjectMapper objectMapper;
    JsonNode jsonNode;

    String jsonStr = JSONReader.readJSON("testJson.json");
    BookItemDeserializer bookItemDeserializer = new BookItemDeserializer();
    JsonParser jsonParser = (JsonParser) Json.createParser(new StringReader(jsonStr));
    ObjectCodec objectCodec = jsonParser.getCodec();


    @BeforeEach
    void init() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new BookJsonModule());
        jsonNode = objectCodec.readTree(jsonParser);
    }

    @Test
    void bookDeserialize() throws JsonProcessingException {
        Book book = objectMapper.readValue(jsonStr, Book.class);

        assertEquals("test", book.getBookId());
        assertEquals("test", book.getEtag());
        assertEquals("test", book.getKind());
        assertEquals("test", book.getSelfLink());
    }

    @Test
    void accessInfoDeserialize() throws JsonProcessingException {
        AccessInfo accessInfo = bookItemDeserializer.readAccessInfo();
    }

    @Test
    void authorDeserialize() throws JsonProcessingException {}

    @Test
    void epubDeserialize() throws JsonProcessingException {}

    @Test
    void imageLinksDeserialize() throws JsonProcessingException {}

    @Test
    void industryIdentifierDeserialize() throws JsonProcessingException {}

    @Test
    void pdfDeserialize() throws JsonProcessingException {}

    @Test
    void readingModelDeserialize() throws JsonProcessingException {}

    @Test
    void saleInfoDeserialize() throws JsonProcessingException {}

    @Test
    void searchInfoDeserialize() throws JsonProcessingException {}

    @Test
    void volumeInfoDeserialize() throws JsonProcessingException {}
}