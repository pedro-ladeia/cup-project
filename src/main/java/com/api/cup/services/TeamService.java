package com.api.cup.services;

import com.api.cup.models.TeamModel;
import com.api.cup.repositories.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    final TeamRepository teamRepository;
    public TeamService (TeamRepository teamRepository) {
        this.teamRepository = teamRepository; // Create the injection point
    }

    public boolean existsByCountryNameTeam(String teamName) { return teamRepository.existsByCountryNameTeam(teamName); }
    public List<TeamModel> findAll() {
        return teamRepository.findAll();
    }

    public Optional<TeamModel> findById(UUID id) { return teamRepository.findById(id); }

    @Transactional
    public TeamModel save(TeamModel teamModel) { return teamRepository.save(teamModel); }

    @Transactional
    public void deleteById(UUID id) { teamRepository.deleteById(id);}

}
