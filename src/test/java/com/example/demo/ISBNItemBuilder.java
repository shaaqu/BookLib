package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ISBNItemBuilder implements ItemRequestBuilder{

    private MockMvc mockMvc;

    public ISBNItemBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Override
    public ResultActions getItem() throws Exception {
        return mockMvc.perform(get("/isbn/{isbn}", 1111));
    }
}
