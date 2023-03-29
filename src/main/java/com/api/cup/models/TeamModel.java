package com.api.cup.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "team_TB")
public class TeamModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTeam;
    @Column(nullable = false, unique = true, length = 60)
    private String countryNameTeam;
    @Column(nullable = false, unique = true)
    private Integer numGolsTeam;

    public UUID getId_Team() {
        return idTeam;
    }

    public void setId_Team(UUID id_Team) {
        this.idTeam = id_Team;
    }

    public String getCountry_name_Team() {
        return countryNameTeam;
    }

    public void setCountry_name_Team(String country_name_Team) {
        this.countryNameTeam = country_name_Team;
    }

    public Integer getNum_gols_Team() {
        return numGolsTeam;
    }

    public void setNum_gols_Team(Integer num_gols_Team) {
        this.numGolsTeam = num_gols_Team;
    }
}
