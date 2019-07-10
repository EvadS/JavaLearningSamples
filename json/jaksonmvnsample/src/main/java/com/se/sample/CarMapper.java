package com.se.sample;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


/**
 * Created by Evgeniy Skiba on 26.Mar.2019
 */
public class CarMapper {

    public static  void test1() throws IOException {
       ObjectMapper objectMapper = new ObjectMapper();
       Car car = new Car("yellow", "renault",1999);
       objectMapper.writeValue(new File("target/car.json"), car);
    }

    public static  void test2() throws IOException {

        try {


            ObjectMapper objectMapper = new ObjectMapper();
            String json = //"{\"color\":\"yellow\",\"type\":\"renault\",\"year\":\"1999\"}";
                        "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"year\" : 2010 }";
            Car car = objectMapper.readValue(json, Car.class);

            System.out.println("car : ");
            System.out.println(car);

        }catch(JsonParseException e)
        {
             int aas =10;
        }
        catch(JsonMappingException e)
        {
            int aas =10;
        }
    }



    public static  void test3() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(new File("target/json_car.json"), Car.class);

       // System.out.println("car : ");
       /// System.out.println(car);

    }
}
