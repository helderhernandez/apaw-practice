package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class DeveloperEntity {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private Integer yearsOfExperience;

    public DeveloperEntity() {
        //empty for framework
    }

    public DeveloperEntity(String name, String email, Integer yearsOfExperience) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
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

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (email.equals(((DeveloperEntity) obj).email));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DeveloperEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

}
