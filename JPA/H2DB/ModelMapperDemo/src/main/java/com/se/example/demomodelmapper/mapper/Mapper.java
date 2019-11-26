package com.se.example.demomodelmapper.mapper;

import com.se.example.demomodelmapper.dto.AbstractDto;
import com.se.example.demomodelmapper.entity.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
