package com.se.example.footballtournamentmanagment.controller;


import com.se.example.footballtournamentmanagment.dto.PlayerDTO;
import com.se.example.footballtournamentmanagment.dto.TeamDTO;
import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.Team;
import com.se.example.footballtournamentmanagment.services.PlayerService;
import com.se.example.footballtournamentmanagment.services.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.Future;

@RestController
@Api(tags = "TeamController", value = "Controller for manage teams")
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);


    @ApiOperation("Returns page of teams in the system.")
    @GetMapping("/team/{page}/{pageSize}")
    public Future<Page<Team>> getAll(@SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort,
                                     @PathVariable(value = "page") int currentPage,
                                     @PathVariable(value = "pageSize") int pageSize) {

        return teamService.find(currentPage, pageSize, sort);
    }

    @ApiOperation("Create new team")
    @RequestMapping(path = "/team", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> create(@Valid @ModelAttribute("team") TeamDTO team) {
        if (teamService.create(team) != null) {//вернуть /id созданного
            return new ResponseEntity<>("Success: ", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);

    }

    @ApiOperation("Update team")
    @RequestMapping(path = "/team", method = RequestMethod.PUT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> update(@Valid @ModelAttribute("team") TeamDTO team) {
        try {
            if (teamService.update(team) != null) {//вернуть /id созданного
                return new ResponseEntity<>("Success: ", HttpStatus.OK);
            }
        } catch (IOException e) {
            return new ResponseEntity<>(String.format("Error: %s ",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/image")
    public ResponseEntity<?> photoUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") Long id) {

        if (teamService.updatePhoto(id, file)!= null)
            return new ResponseEntity<>("Success: ", HttpStatus.OK);

        return new ResponseEntity<>("Error: ", HttpStatus.BAD_REQUEST);
    }

    // TODO: get image

}
