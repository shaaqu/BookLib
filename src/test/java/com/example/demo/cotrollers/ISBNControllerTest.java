package com.example.demo.cotrollers;

import com.example.demo.ItemRequestBuilder;
import com.example.demo.ItemRequestBuilderFactory;
import com.example.demo.controllers.CategoriesController;
import com.example.demo.controllers.ISBNController;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.ISBNService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.ItemRequestBuilderFactory.Items.AUTHORS_RANKING_ITEM;
import static com.example.demo.ItemRequestBuilderFactory.Items.ISBN_ITEM;
import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ISBNControllerTest {

    private ItemRequestBuilder itemRequestBuilder;
    private ISBNService service;
    private ItemRequestBuilderFactory factory;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(ISBNService.class);
        ISBNController isbnController = new ISBNController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(isbnController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();
        factory = new ItemRequestBuilderFactory(mockMvc);
        itemRequestBuilder = factory.createRequestBuilder(ISBN_ITEM);

    }

    @Test
    public void getItemTest() throws Exception {
        itemRequestBuilder.getItem().andExpect(status().isOk())
                .andDo(print());

    }
}
