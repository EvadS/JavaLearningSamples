package com.se.example.footballtournamentmanagment.controller;


import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.services.PlayerAmpluaService;
import com.se.example.footballtournamentmanagment.services.PlayerAmpluaServiceImpl;
import org.aspectj.apache.bcel.util.Play;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PlayerampluaRestControllerIT {

    @Autowired
    private MockMvc mvc;

 //   @MockBean
 //   private PlayerAmpluaService service;

    @Autowired
    private PlayerAmpluaRepository repository;

    @TestConfiguration
    static class PlayerampluaRestController {
        @Bean
        public PlayerAmpluaService playerAmpluaService() {
            return new PlayerAmpluaServiceImpl();
        }
    }

    @After
    public void resetDb() {
        repository.deleteAll();
    }


    // write test cases here

    private void createTestEmployee(String name) {
        PlayerAmplua amplua = new PlayerAmplua(name);
        repository.save(amplua);
    }



    @Test
    public void whenGetApluasASC_thenStatus200() throws Exception {
        createTestEmployee("winger");
        createTestEmployee("forward");

        Pageable sortedByName = PageRequest.of(0, 100,  new Sort(Sort.Direction.ASC, "positionName"));
        List<PlayerAmplua> list = repository.findAll(sortedByName).getContent();

        // @formatter:off
        ResultActions res = mvc.perform(get("/api/apmpluas/apmplua/0/100").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
              //  .andExpect(jsonPath("$content", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$.content[0].positionName", is("forward")))
                .andExpect(jsonPath("$.content[1].positionName", is("winger")))
        ;
        // @formatter:on
    }

    @Test
    public void whenGetApluasDESC_thenStatus200() throws Exception {
        createTestEmployee("winger");
        createTestEmployee("forward");

        Pageable sortedByName = PageRequest.of(0, 100,  new Sort(Sort.Direction.DESC, "positionName"));
        List<PlayerAmplua> list = repository.findAll(sortedByName).getContent();

        // @formatter:off
        ResultActions res = mvc.perform(get("/api/apmpluas/apmplua/0/100?sort=positionName,desc")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //  .andExpect(jsonPath("$content", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$.content[1].positionName", is("forward")))
                .andExpect(jsonPath("$.content[0].positionName", is("winger")))
                ;
        // @formatter:on
    }
}
