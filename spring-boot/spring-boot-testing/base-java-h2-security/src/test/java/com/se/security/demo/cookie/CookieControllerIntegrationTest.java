package com.se.security.demo.cookie;

import com.se.security.demo.config.SecurityConfig;
import com.se.security.demo.security.CustomUserDetailsService;
import com.se.security.demo.security.TokenProperties;
import com.se.security.demo.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CookieController.class)
@Import({TokenProperties.class, BCryptPasswordEncoder.class, CustomUserDetailsService.class, SecurityConfig.class})
public class CookieControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private RandomCookieJar cookieJar;

    @Test
    @WithMockUser(roles = "USER")
    public void getsCookies() throws Exception {
        String chocolate = "chocolate";
        when(cookieJar.getCookies())
                .thenReturn( Arrays.asList(new Cookie(chocolate)));

        mvc.perform(get("/api/cookies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].flavour", is(chocolate)))
                .andExpect(status().isOk());
    }
}