package com.se.example.footballtournamentmanagment.controller;


import com.se.example.footballtournamentmanagment.dto.PlayerDTO;
import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.services.PlayerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.Future;

@RestController
@Api(tags = "PlayerController", value = "Controller for manage players")
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);


    @ApiOperation("Returns list of all players in the system.")
    @GetMapping("/apmplua/{page}/{pageSize}")
    public Future<Page<Player>> getAll(@SortDefault(sort = "positionName", direction = Sort.Direction.ASC) Sort sort,
                                       @PathVariable(value = "page") int currentPage,
                                       @PathVariable(value = "pageSize") int pageSize) {

        return playerService.findall(currentPage, pageSize, sort);
    }


    @ApiOperation("Create new player")
    @RequestMapping(path = "/player", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createPlayer(@Valid @ModelAttribute("player") PlayerDTO player) {

        if (playerService.StorePlayer(player) != null) {//вернуть /id созданного
            return new ResponseEntity<>("Success: ", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }


    // update a new Note
    @RequestMapping(path = "/player", method = RequestMethod.PUT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updatePlayer(@Valid @ModelAttribute("player") PlayerDTO player) throws IOException {

        if (playerService.updatePlayer(player) != null) {
            return new ResponseEntity<>("Success: ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/image")
    public ResponseEntity<?> photoUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("playerId") Long playerID) {

        if (playerService.updatePhoto(playerID, file)!= null)
            return new ResponseEntity<>("Success: ", HttpStatus.OK);

        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/image")
    public ResponseEntity<?> getImage() {
        throw new NotImplementedException();
    }


    @DeleteMapping("/player/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long playerId) {

        if (playerService.delete(playerId))
            return new ResponseEntity<>("Success: ", HttpStatus.OK);
        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }
}