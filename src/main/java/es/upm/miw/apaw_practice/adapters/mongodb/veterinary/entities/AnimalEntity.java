package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class AnimalEntity {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime date;
    private Boolean isMale;
    @DBRef
    private ClientEntity client;

    public AnimalEntity() {
        //Empty for framework;
    }

    public AnimalEntity(String id, String name, Integer age, LocalDateTime date, Boolean isMale, ClientEntity client) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date = date;
        this.isMale = isMale;
        this.client = client;
    }

    public AnimalEntity(AnimalCreation animalCreation) {
        BeanUtils.copyProperties(animalCreation, this);
        this.date = LocalDateTime.now();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isMAle() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity that = (AnimalEntity) o;
        return age == that.age &&
                isMale == that.isMale &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AnimalEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", isMAle=" + isMale +
                ", client=" + client +
                '}';
    }

    public Animal toAnimal() {
        Animal animal = new Animal();
        BeanUtils.copyProperties(this, animal);
        return animal;
    }
}
