package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;


public class MemberTeamDto {
    private String id;
    private String dni;

    public MemberTeamDto() {
        //Empty constructor for the framework
    }

    public MemberTeamDto(MemberTeam memberTeam) {
        this.id = memberTeam.getId();
        this.dni = memberTeam.getDni();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "MemberTeamDto{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
