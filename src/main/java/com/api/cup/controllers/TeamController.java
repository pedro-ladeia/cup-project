package com.api.cup.controllers;

import com.api.cup.dtos.TeamDto;
import com.api.cup.models.TeamModel;
import com.api.cup.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/team")
public class TeamController {
    final TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;

    } //Creating the injection point

    @GetMapping
    public ResponseEntity<List<TeamModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(teamService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        Optional<TeamModel> teamModelOptional = teamService.findById(id);
        if(!teamModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(teamModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TeamDto teamDto) { //Receiving the data by way of json

        if (teamService.existsByCountryNameTeam(teamDto.getCountry_name_Team())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Team name is already in use. ");
        }
        var teamModel = new TeamModel();
        BeanUtils.copyProperties(teamModel, teamDto); //Copying the teamDto properties to the instance created
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(teamModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<TeamModel> teamModelOptional = teamService.findById(id);
        if(!teamModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Team not found. ");
        }
        teamService.deleteById(teamModelOptional.get().getId_Team());
        return ResponseEntity.status(HttpStatus.OK).body("Team deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody TeamDto teamDto) {
        Optional<TeamModel> teamModelOptional = teamService.findById(id);
        if(!teamModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Team not found. ");
        }
        var teamModel = new TeamModel();
        BeanUtils.copyProperties(teamDto, teamModel);
        teamModel.setId_Team(teamModelOptional.get().getId_Team());
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(teamModel));
    }

}
