package com.se.example.unittestsample.controller.pub;

import com.se.example.unittestsample.model.WalletChanges;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotifiactionController {

    @PostMapping("/changes")
    public void getNotification(@RequestBody WalletChanges walletChanges ){

        System.out.println("------------ HERE -----------");

        System.out.println("\n\n\n\n walletChanges " + walletChanges.getWalletAddress() +"\n\n =========== \n");

    }
}
