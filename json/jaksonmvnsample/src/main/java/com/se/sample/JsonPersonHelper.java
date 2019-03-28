package com.se.sample;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Evgeniy Skiba on 26.Mar.2019
 */
public class JsonPersonHelper {
    public static  void test_write_to_file() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String str = "Address";
        byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
        Address address = new Address(byteArr);
        Person person = new Person(1,"fname","lname",address );
        objectMapper.writeValue(new File("target/person.json"), person);
    }
}
