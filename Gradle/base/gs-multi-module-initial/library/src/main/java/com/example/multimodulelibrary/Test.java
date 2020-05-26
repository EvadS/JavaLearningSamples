package com.example.multimodulelibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeniy Skiba on 26.05.2020
 * @project spring-boot-multimodule-app
 */
@Data
@AllArgsConstructor
public class Test {
    private int id;
    private  String name;
}
