package es.upm.miw.apaw_practice.domain.models.videogame;

import java.util.UUID;

public class GameDeveloperCreation {

    private String id;
    private String name;
    private String email;
    private Integer phone;

    public GameDeveloperCreation() {
        //empty for framework
    }

    public GameDeveloperCreation(String name, String email, Integer phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "GameDeveloperCreation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
