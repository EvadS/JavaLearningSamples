package com.se.example.propertiessample.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sunny", "default","dev"})
public class SunnyDayService implements WeatherService {

    @Override
    public String forecast() {
        return "Today is sunny day!";
    }

}
