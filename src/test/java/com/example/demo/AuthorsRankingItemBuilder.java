package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class AuthorsRankingItemBuilder implements ItemRequestBuilder{

    private MockMvc mockMvc;

    public AuthorsRankingItemBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Override
    public ResultActions getItem() throws Exception {
        return mockMvc.perform(get("/ranking"));
    }
}
