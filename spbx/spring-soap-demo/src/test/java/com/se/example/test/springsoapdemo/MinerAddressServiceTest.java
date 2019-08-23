package com.se.example.springsoapdemo;

import com.soapbox.basenode.crypto.CryptoController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AppContainerConfig.class,CryptoControllerConfig.class})
public class MinerAddressServiceTest {
    @Autowired
    private CryptoController cryptoController;

    @Autowired
    private  NodeAddressService addressService;

    @Before
    public  void init(){
        cryptoController.init();
    }

    @Test
    public  void test1(){}
}
