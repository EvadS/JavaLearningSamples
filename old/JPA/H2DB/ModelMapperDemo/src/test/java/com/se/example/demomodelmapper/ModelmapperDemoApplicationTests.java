package com.se.example.demomodelmapper;


import com.se.example.demomodelmapper.attributes.Color;
import com.se.example.demomodelmapper.attributes.Filling;
import com.se.example.demomodelmapper.dto.UnicornDto;
import com.se.example.demomodelmapper.entity.Cupcake;
import com.se.example.demomodelmapper.entity.Droid;
import com.se.example.demomodelmapper.entity.Unicorn;
import com.se.example.demomodelmapper.mapper.UnicornMapper;
import com.se.example.demomodelmapper.repository.CupcakeRepository;
import com.se.example.demomodelmapper.repository.DroidRepository;
import com.se.example.demomodelmapper.repository.UnicornRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelmapperDemoApplicationTests {
    private List<Cupcake> cupcakes;
    private List<Droid> droids;
    private Unicorn unicorn;

    @Autowired
    private UnicornMapper unicornMapper;

    @Autowired
    private UnicornRepository unicornRepository;

    @Autowired
    private DroidRepository droidRepository;

    @Autowired
    private CupcakeRepository cupcakeRepository;

    @Before
    public void init() {
        unicorn = createUnicorn();
        droids = createDroids(unicorn);
        cupcakes = droids.stream().flatMap(d -> createCupcakes(d).stream()).collect(Collectors.toList());
    }

    @Test
    public void mapperTest() {
        unicorn = unicornRepository.findById(unicorn.getId())
                .orElseThrow(() -> new DataAccessException("Unable to get entity from Database by id " + unicorn.getId()) {
                });
        droids = droidRepository.findAllByIdIn(droids.stream().map(Droid::getId).collect(Collectors.toList()));
        cupcakes = cupcakeRepository.findAllByIdIn(cupcakes.stream().map(Cupcake::getId).collect(Collectors.toList()));

        UnicornDto unicornDto = unicornMapper.toDto(unicorn);
        unicorn = unicornMapper.toEntity(unicornDto);

        Assert.assertEquals(unicorn.getId(), unicornDto.getId());
    }

    private Unicorn createUnicorn() {
        return unicornRepository.save(new Unicorn("Unicorn " + LocalTime.now(), Color.PINK));
    }

    private List<Droid> createDroids(Unicorn unicorn) {
        return Stream.generate(() -> droidRepository.save(new Droid("Droid " + LocalTime.now(), unicorn, true)))
                .limit(3L)
                .collect(Collectors.toList());
    }

    private List<Cupcake> createCupcakes(Droid droid) {
        return Stream.generate(() -> cupcakeRepository.save(
                new Cupcake(Arrays.stream(Filling.values()).findAny().orElse(Filling.CHERRY), droid))
        )
                .limit(3L)
                .collect(Collectors.toList());
    }
}
