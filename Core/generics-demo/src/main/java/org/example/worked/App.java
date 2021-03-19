package org.example.worked;

import java.util.Scanner;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public class App {
    public static void main(String[] args) {

        BlockedResourceId<Long> longResource = new BlockingAccountIdResource<>(1000l);


        Long lonId = longResource.accountId();

        Scanner in = new Scanner(System.in);
        System.out.println("Press any key ");
        String key = in.nextLine();
    }
}