package com.se.sample.basemvcservice.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BookUpdateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotNull
    private int year;

}
