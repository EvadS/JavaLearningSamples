package com.se.example.footballtournamentmanagment.controller;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.services.PlayerAmpluaService;
import com.se.example.footballtournamentmanagment.services.PlayerAmpluaServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PlayerAmpluaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PlayerAmpluaService playerAmpluaService;

    @Autowired
    PlayerAmpluaRepository playerAmpluaRepository;

    @TestConfiguration
    static class PlayerAmpluaController {
        @Bean
        public PlayerAmpluaService playerAmpluaService() {
            return new PlayerAmpluaServiceImpl();
        }
    }

    @After
    public void resetDb() {

        playerAmpluaRepository.deleteAll();
    }

    @Before
    public void setUp() throws Exception {
        playerAmpluaRepository.deleteAll();
    }

    @Test
    public void getAll() {
    }

    @Test
    public void whenValidInput_thencrateAmplua() throws IOException,Exception {
        PlayerAmplua amplua = new PlayerAmplua("winger22");

            mvc.perform(post("/api/apmpluas/apmplua")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtil.toJson(amplua)));

        Pageable sortedByName = PageRequest.of(0, 100,  new Sort(Sort.Direction.ASC, "positionName"));
        Page<PlayerAmplua> ampluasPage = playerAmpluaRepository.findAll(sortedByName);

        int size = ampluasPage.getContent().size();
        assertThat(size).isEqualTo(1);
        List<PlayerAmplua> res = ampluasPage.getContent();

        ampluasPage.getContent().contains(amplua);

      //  assertThat(ampluasPage.getContent().get(0)).extracting(PlayerAmplua::getPositionName).isEqualTo("winger22");
    }

    @Test
    public void getById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}