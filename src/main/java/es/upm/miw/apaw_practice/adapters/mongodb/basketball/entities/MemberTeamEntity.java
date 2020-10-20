package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.builders.MemberTeamBuilder;
import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class MemberTeamEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String dni;
    private Boolean available;

    public MemberTeamEntity() {
        //Empty constructor for the framework
    }

    public static MemberTeamBuilder.Name builder() {
        return new Builder();
    }

    public MemberTeamEntity(String name, String surname, String dni, Boolean available) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public MemberTeam toMemberTeam() {
        MemberTeam memberTeam = new MemberTeam();
        BeanUtils.copyProperties(this, memberTeam);
        return memberTeam;
    }

    public static class Builder implements MemberTeamBuilder.Name, MemberTeamBuilder.Surname, MemberTeamBuilder.Dni,
            MemberTeamBuilder.Available, MemberTeamBuilder.BuildMember {

        private MemberTeamEntity memberTeamEntity;

        public Builder() {
            this.memberTeamEntity = new MemberTeamEntity();
            this.memberTeamEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public MemberTeamBuilder.Surname name(String name) {
            this.memberTeamEntity.name = name;
            return this;
        }

        @Override
        public MemberTeamBuilder.Dni surname(String surname) {
            this.memberTeamEntity.surname = surname;
            return this;
        }

        @Override
        public MemberTeamBuilder.Available dni(String dni) {
            this.memberTeamEntity.dni = dni;
            return this;
        }

        @Override
        public MemberTeamBuilder.BuildMember available(Boolean available) {
            this.memberTeamEntity.available = available;
            return this;
        }

        @Override
        public MemberTeamEntity build() {
            return this.memberTeamEntity;
        }
    }
}
