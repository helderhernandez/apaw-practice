package es.upm.miw.apaw_practice.domain.models.padel;

public class PlayerCreation {
    private String name;
    private String surname;
    private String dni;
    private String email;
    private Boolean federated;

    public PlayerCreation(String name, String surname, String dni, String email, Boolean federated) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.email = email;
        this.federated = federated;
    }

    public PlayerCreation(){
        //Empty for Framework
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

    @Override
    public String toString() {
        return "PlayerCreation{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", federated=" + federated +
                '}';
    }
}
