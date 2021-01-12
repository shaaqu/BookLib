package com.example.demo.cotrollers;

import com.example.demo.ItemRequestBuilder;
import com.example.demo.ItemRequestBuilderFactory;
import com.example.demo.controllers.AuthorsRankingController;
import com.example.demo.services.AuthorsRankingService;
import com.example.demo.services.CategoriesService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.ItemRequestBuilderFactory.Items.AUTHORS_RANKING_ITEM;
import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoriesControllerTest {

    private ItemRequestBuilder itemRequestBuilder;
    private CategoriesService service;
    private ItemRequestBuilderFactory factory;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(AuthorsRankingService.class);
        AuthorsRankingController accountController = new AuthorsRankingController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();
        factory = new ItemRequestBuilderFactory(mockMvc);
        itemRequestBuilder = factory.createRequestBuilder(AUTHORS_RANKING_ITEM);

    }

    @Test
    public void getItemTest() throws Exception {
        itemRequestBuilder.getItem().andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }
}
