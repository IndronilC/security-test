package com.abc.securitytest.unit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    MockMvc mockMvc;
    private static final String API_V1_LOGIN = "/api/v1/login";

    @Test
    public void givenPostLogin_whenWithoutUserCredentials_thenReceivedUnAuthorized() throws Exception {
        createMockResponseAndAssert();

    }

    private void createMockResponseAndAssert() throws Exception {
        ResultActions response = mockMvc.perform(post(API_V1_LOGIN)
                        .contentType(MediaType.APPLICATION_JSON));
        response.andDo(print())
                .andExpect(status().isUnauthorized());
    }


    @Test
    public void givenPostLogin_whenWithInvalidUserCredentials_thenReceivedForBidden() throws Exception {
        ResultActions response = mockMvc.perform(post(API_V1_LOGIN)
                .with(httpBasic("Indronil", "darga@786"))
                .contentType(MediaType.APPLICATION_JSON));
        response.andDo(print())
                .andExpect(status().isForbidden());
    }


    @Test
    public void givenPostLogin_whenWithValidUserCredentials_thenReceiveStatusOk() throws Exception{
        ResultActions response = mockMvc.perform(post(API_V1_LOGIN)
                .with(httpBasic("Shawbori", "maindra@777"))
                .contentType(MediaType.APPLICATION_JSON));
        response.andDo(print())
                .andExpect(status().isOk());
    }


}
