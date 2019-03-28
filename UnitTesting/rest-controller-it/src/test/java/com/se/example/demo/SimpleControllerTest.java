package com.se.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// SpringRunner is an alias of SpringJUnit4ClassRunner
// it's a Spring extension of JUnit that handles the TestContext
@RunWith(SpringRunner.class)

// we test only the SimpleController
@WebMvcTest(SimpleController.class)

public class SimpleControllerTest {

    // we inject the server side Spring MVC test support
    @Autowired
    private MockMvc mockMvc;

    // we mock the service, here we test only the controller
    // @MockBean is a Spring annotation that depends on mockito framework
    @MockBean
    private SimpleService simpleServiceMocked;

    @Test
    public void simpleResult() throws Exception {

        // this is the expected JSON answer
        String responseBody = "{\"content\":\"Hello World from Spring!\"}";

        // we set the result of the mocked service
        given(simpleServiceMocked.getText())
                .willReturn(new StringJsonObject("Hello World from Spring!"));

        // the test is executed:
        // perform: it executes the request and returns a ResultActions object
        // accept: type of media accepted as response
        // andExpect: ResultMatcher object that defines some expectations
        this.mockMvc.perform(get("/simple")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(responseBody));

    }
}