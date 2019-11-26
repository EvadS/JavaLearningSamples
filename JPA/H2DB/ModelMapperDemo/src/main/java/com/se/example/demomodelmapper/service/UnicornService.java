package com.se.example.demomodelmapper.service;


import com.se.example.demomodelmapper.dto.UnicornDto;

public interface UnicornService {

    UnicornDto save(UnicornDto dto);

    UnicornDto get(Long id);
}
