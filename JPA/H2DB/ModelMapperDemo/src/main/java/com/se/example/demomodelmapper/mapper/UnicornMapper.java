package com.se.example.demomodelmapper.mapper;

import com.se.example.demomodelmapper.dto.UnicornDto;
import com.se.example.demomodelmapper.entity.Unicorn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnicornMapper extends AbstractMapper<Unicorn, UnicornDto> {

    @Autowired
    public UnicornMapper() {
        super(Unicorn.class, UnicornDto.class);
    }
}