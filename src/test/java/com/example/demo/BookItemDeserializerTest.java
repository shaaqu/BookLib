package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookItemDeserializerTest {

    @Test
    void bookDeserialize(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new BookJsonModul())
    }

}