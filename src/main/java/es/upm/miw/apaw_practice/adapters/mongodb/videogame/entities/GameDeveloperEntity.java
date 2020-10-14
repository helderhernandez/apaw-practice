package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class GameDeveloperEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private Integer phone;

    public GameDeveloperEntity() {
        //empty for framework
    }

    public GameDeveloperEntity(String name, String email, Integer phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public GameDeveloperEntity(GameDeveloperCreation gameDeveloperCreation) {
        BeanUtils.copyProperties(gameDeveloperCreation, this);
        this.id = UUID.randomUUID().toString();

    }

    public GameDeveloperEntity(GameDeveloper gameDeveloper) {
        BeanUtils.copyProperties(gameDeveloper, this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDeveloperEntity that = (GameDeveloperEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }

    public GameDeveloper toGameDeveloper() {
        return GameDeveloper.builder(id)
                .name(name)
                .email(email)
                .phone(phone)
                .build();
    }

    @Override
    public String toString() {
        return "GameDeveloperEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
