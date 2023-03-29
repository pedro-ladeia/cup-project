package com.api.cup.repositories;

import com.api.cup.models.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel, UUID> {

    boolean existsByCountryNameTeam(String name);
}
