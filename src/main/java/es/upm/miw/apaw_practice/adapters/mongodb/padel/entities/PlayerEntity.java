package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class PlayerEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String dni;
    @Indexed(unique = true)
    private String email;
    private Boolean federated;
    private List<ReservationEntity> reservationEntities;

    public PlayerEntity() {
        //Empty for Spring
    }

    public PlayerEntity(String name, String surname, String dni, String email, Boolean federated, List<ReservationEntity> reservationEntities) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.federated = federated;
        this.reservationEntities = reservationEntities;
    }

    public PlayerEntity(PlayerCreation playerCreation){
        BeanUtils.copyProperties(playerCreation, this);
        this.id = UUID.randomUUID().toString();
        this.reservationEntities= new ArrayList<ReservationEntity>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFederated() {
        return federated;
    }

    public void setFederated(Boolean federated) {
        this.federated = federated;
    }

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public void setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((PlayerEntity) obj).dni));
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", federated=" + federated +
                ", reservationEntities=" + reservationEntities +
                '}';
    }
    public Player toPlayer(){
        Player player = new Player();
        BeanUtils.copyProperties(this, player);
        return player;
    }
}
