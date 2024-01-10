package com.abc.securitytest.unit.controller;

import com.abc.securitytest.user.login.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers=LoginController.class)
public class LoginControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static final String API_V1_LOGIN = "/api/v1/login";


    @Test
    public void givenPostLogin_whenWithoutUserCredentials_thenReceivedForbidden() throws Exception {
        createMockResponseAndAssert();

    }

    private void createMockResponseAndAssert() throws Exception {
        ResultActions response = mockMvc.perform(post(API_V1_LOGIN)
                        .contentType(MediaType.APPLICATION_JSON));
        response.andDo(print())
                .andExpect(status().isForbidden());
    }

    @WithMockUser(value = "indronil")
    @Test
    public void givenPostLogin_whenWithInvalidUserCredentials_thenReceivedForbidden() throws Exception {
        createMockResponseAndAssert();
    }

    @WithMockUser(value = "spring")
    @Test
    public void givenPostLogin_whenWithValiddUserCredentials_thenReceiveStatusOk() throws Exception{
        ResultActions response = mockMvc.perform(post(API_V1_LOGIN)
                .contentType(MediaType.APPLICATION_JSON));
        response.andDo(print())
                .andExpect(status().isOk());
    }


}
