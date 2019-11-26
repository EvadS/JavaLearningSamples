package com.se.example.demomodelmapper.controller;


import com.se.example.demomodelmapper.dto.UnicornDto;
import com.se.example.demomodelmapper.service.UnicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/unicorn")
@RestController
public class UnicornController {

    private final UnicornService service;

    @Autowired
    public UnicornController(UnicornService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UnicornDto> save(@RequestBody UnicornDto unicornDto) {
        return ResponseEntity.ok(service.save(unicornDto));
    }

    @GetMapping
    public ResponseEntity<UnicornDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}