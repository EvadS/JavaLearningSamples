package com.se.example.demomodelmapper.mapper;


import com.se.example.demomodelmapper.dto.DroidDto;
import com.se.example.demomodelmapper.entity.Droid;
import com.se.example.demomodelmapper.repository.UnicornRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.01.19
 * e-mail: 2262288@gmail.com
 */
@Component
public class DroidMapper extends AbstractMapper<Droid, DroidDto> {

    private final ModelMapper mapper;
    private final UnicornRepository unicornRepository;

    @Autowired
    public DroidMapper(ModelMapper mapper, UnicornRepository unicornRepository) {
        super(Droid.class, DroidDto.class);
        this.mapper = mapper;
        this.unicornRepository = unicornRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Droid.class, DroidDto.class)
                .addMappings(m -> m.skip(DroidDto::setUnicornId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(DroidDto.class, Droid.class)
                .addMappings(m -> m.skip(Droid::setUnicorn)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Droid source, DroidDto destination) {
        destination.setUnicornId(getId(source));
    }

    private Long getId(Droid source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getUnicorn().getId();
    }

    @Override
    void mapSpecificFields(DroidDto source, Droid destination) {
        destination.setUnicorn(unicornRepository.findById(source.getUnicornId()).orElse(null));
    }
}