package com.api.cup.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeamDto {

    @NotBlank
    @Size(max = 60)
    private String country_name_Team;
    @NotBlank
    private Integer num_gols_Team;

    public String getCountry_name_Team() {
        return country_name_Team;
    }

    public void setCountry_name_Team(String country_name_Team) {
        this.country_name_Team = country_name_Team;
    }

    public Integer getNum_gols_Team() {
        return num_gols_Team;
    }

    public void setNum_gols_Team(Integer num_gols_Team) {
        this.num_gols_Team = num_gols_Team;
    }
}
