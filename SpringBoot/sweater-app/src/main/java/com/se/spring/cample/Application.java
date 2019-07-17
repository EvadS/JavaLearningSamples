package com.se.spring.cample;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("127.0.0.1");
test();

        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
       // SpringApplication.run(Application.class, args);
    }


    public static  void test (){
        String str2 = "127.0.0.1"; //"fe80:0:0:0:f06c:31b8:cd17:5a44";
        try {
            IPAddressString str = new IPAddressString(str2);
            IPAddress addr = str.toAddress();//throws if invalid, without a DNS lookup
            InetAddress inetAddr = addr.toInetAddress();//convert valid address
            //use address
            int a =10;
        } catch(AddressStringException e) {
            //e.getMessage has validation error
        }
    }
}