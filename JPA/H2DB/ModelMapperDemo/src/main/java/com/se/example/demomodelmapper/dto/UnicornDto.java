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
public class UnicornDto extends AbstractDto {

    private String name;
    private List<DroidDto> droids;
    private String color;
}