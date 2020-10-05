package es.upm.miw.apaw_practice.domain.models.padel;

import java.util.List;

public class Player {
    private String id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private Boolean federated;
    private List<Reservation> reservation;

    public Player() {
        //Empty for Spring
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

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservationEntities) {
        this.reservation = reservationEntities;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", federated=" + federated +
                ", reservation=" + reservation +
                '}';
    }
}
