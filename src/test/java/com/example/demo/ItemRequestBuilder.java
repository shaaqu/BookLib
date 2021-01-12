package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public interface ItemRequestBuilder {

    ResultActions getItem() throws Exception;

}
