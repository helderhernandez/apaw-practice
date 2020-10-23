package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import es.upm.miw.apaw_practice.domain.models.music.Singer;
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

    public static Builder builder(String name){
        return new Builder(name);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public Singer toSinger(){
        Singer singer = new Singer();
        BeanUtils.copyProperties(this,singer);
        return singer;
    }

    @Override
    public String toString() {
        return "SingerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
    public static class Builder {

        private final SingerEntity singer;

        public Builder(String name){
            this.singer = new SingerEntity();
            this.singer.name = name;
        }

        public Builder surname(String surname){
            this.singer.surname = surname;
            return this;
        }

        public Builder nationality(String nationality){
            this.singer.nationality = nationality;
            return this;
        }

        public SingerEntity build(){
            return this.singer;
        }
    }

}
