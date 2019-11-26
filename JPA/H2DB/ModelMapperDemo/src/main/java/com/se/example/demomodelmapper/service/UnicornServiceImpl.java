package com.se.example.demomodelmapper.service;

import com.se.example.demomodelmapper.dto.UnicornDto;
import com.se.example.demomodelmapper.mapper.UnicornMapper;
import com.se.example.demomodelmapper.repository.UnicornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnicornServiceImpl implements UnicornService {

    private final UnicornRepository repository;
    private final UnicornMapper mapper;

    @Autowired
    public UnicornServiceImpl(UnicornRepository repository, UnicornMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UnicornDto save(UnicornDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public UnicornDto get(Long id) {
        return mapper.toDto(repository.getOne(id));
    }
}
