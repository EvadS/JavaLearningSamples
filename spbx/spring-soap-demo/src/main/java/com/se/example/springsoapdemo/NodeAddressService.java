package com.se.example.springsoapdemo;

import com.soapbox.basenode.AppContainer;
import com.soapbox.basenode.crypto.CryptoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeAddressService {

    @Autowired
    private CryptoController cryptoController;


    void  test(){
        cryptoController.exit();
    }
//    private CryptoController accountManager = AppContainer.getBean(CryptoController.class);

}
