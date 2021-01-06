package com.example.demo.services;

import com.example.demo.BookItemDeserializer;
import com.example.demo.entities.Book;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookJsonModule extends SimpleModule {

}
