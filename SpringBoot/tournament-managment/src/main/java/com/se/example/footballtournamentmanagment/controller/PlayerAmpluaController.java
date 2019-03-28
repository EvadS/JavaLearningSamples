package com.se.example.footballtournamentmanagment.controller;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.services.PlayerAmpluaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/apmpluas")
//@Api(tags = "FileController", value = "Controller for manage files")
public class PlayerAmpluaController {

    @Autowired
    private PlayerAmpluaService playerAmpluaService;

    // Get All
    //http://localhost:8091/apmplua/apmpluas/0/10
    @GetMapping("/apmplua/{page}/{pageSize}")
    public Page<PlayerAmplua> getAll(@SortDefault(sort = "positionName", direction = Sort.Direction.ASC) Sort sort,
                                     @PathVariable(value = "page") int currentPage,
                                     @PathVariable(value = "pageSize") int pageSize ) {
        return playerAmpluaService.findall(currentPage, pageSize, sort);
    }


    // Create a new Note
    @PostMapping("/apmplua")
    public PlayerAmplua crateAmplua(@Valid @RequestBody PlayerAmplua amplua) {
        PlayerAmplua playerAmplua = playerAmpluaService.create(amplua);
        return playerAmplua;
    }

    // Get a Single Note
    @GetMapping("/apmplua/{id}")
    public PlayerAmplua getById(@PathVariable(value = "id") Long ampluaId) {
        return playerAmpluaService.find(ampluaId);
    }

    // Update a Note
    @PutMapping("/apmplua/{id}")
    public PlayerAmplua update(@PathVariable(value = "id") Long ampluaId,
                               @Valid @RequestBody PlayerAmplua playerAmplua) {
        return playerAmpluaService.updatedAmplua(playerAmplua);
    }

    // Delete a Note
    @DeleteMapping("/apmplua/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long ampluaId) {
        playerAmpluaService.delete(ampluaId);
        return ResponseEntity.ok().build();
    }
}
