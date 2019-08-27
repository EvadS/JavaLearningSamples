package com.se.example.test.springsoapdemo;

import com.soapbox.basenode.crypto.CryptoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeAddressServiceImpl implements NodeAddressService {

    @Autowired
    private CryptoController cryptoController;



    @Override
    public void test() {
        cryptoController.exit();
    }
//    private CryptoController accountManager = AppContainer.getBean(CryptoController.class);

}
