package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PlayerAmpluaServiceImplIT {

    @Autowired
    private PlayerAmpluaService playerAmpluaService;

    @MockBean
    PlayerAmpluaRepository playerAmpluaRepository;

    @TestConfiguration
    static class PlayerAmpluaServiceImplTest {
        @Bean
        public PlayerAmpluaService playerAmpluaService() {
            return new PlayerAmpluaServiceImpl();
        }
    }

    @Before
    public void setUp() {
        PlayerAmplua amplua = new PlayerAmplua("winge2");
    
          Mockito.when(playerAmpluaRepository.findByPositionName(amplua.getPositionName()))
                .thenReturn(amplua);

        PlayerAmplua found = playerAmpluaService.findByAmplua(amplua.getPositionName());
          int a = 1;
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "winger";
        PlayerAmplua found = playerAmpluaService.findByAmplua(name);

        Assert.assertEquals(found.getPositionName(),name);
    }
}
