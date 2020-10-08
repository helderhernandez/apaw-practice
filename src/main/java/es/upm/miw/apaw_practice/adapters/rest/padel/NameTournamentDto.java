package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Tournament;

public class NameTournamentDto {
    private String name;

    public NameTournamentDto() {
        //For framework
    }

    public NameTournamentDto(Tournament tournament) {
        this.name = tournament.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameTournamentDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
