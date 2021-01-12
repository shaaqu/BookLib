package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;

public class ItemRequestBuilderFactory {

    private MockMvc mockMvc;

    public enum Items{
        AUTHORS_RANKING_ITEM,
        CATEGORIES_ITEM,
        ISBN_ITEM
    }

    public ItemRequestBuilderFactory(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public ItemRequestBuilder createRequestBuilder(Items item) {
        switch (item) {
            case ISBN_ITEM:
                return new ISBNItemBuilder(mockMvc);
            case CATEGORIES_ITEM:
                return new CategoriesItemBuilder(mockMvc);
            case AUTHORS_RANKING_ITEM:
                return new AuthorsRankingItemBuilder(mockMvc);
            default:
                throw new IllegalArgumentException("Unknown Request Builder");
        }
    }
}
