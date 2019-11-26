package com.se.example.demomodelmapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroidDto extends AbstractDto {

    private Long unicornId;

    private String name;
    private List<CupcakeDto> cupcakes;
    private Boolean alive;
}
