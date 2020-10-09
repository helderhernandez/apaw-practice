package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;


import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document

public class SingerEntity {

    @Id
    private String id;
    private String name;
    private String surname;
    private String nationality;

    public SingerEntity(){
        //Empty for framework
    }

    public SingerEntity( String name, String surname, String nationality) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }





    @Override
    public String toString() {
        return "SingerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
