package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class CategoriesItemBuilder implements ItemRequestBuilder{

    private MockMvc mockMvc;

    public CategoriesItemBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Override
    public ResultActions getItem() throws Exception {
        return mockMvc.perform(get("/categories/category"));
    }
}
