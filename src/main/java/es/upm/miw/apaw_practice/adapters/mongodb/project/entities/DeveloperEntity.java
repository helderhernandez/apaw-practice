package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

import es.upm.miw.apaw_practice.domain.models.project.Developer;
import org.springframework.beans.BeanUtils;
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

    public static DeveloperEntityBuilder.Name builder() {
        return new Builder();
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

    public Developer toDeveloper() {
        Developer developer = new Developer();
        BeanUtils.copyProperties(this, developer);
        return developer;
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

    public static class Builder implements DeveloperEntityBuilder.Name, DeveloperEntityBuilder.Email, DeveloperEntityBuilder.Optionals {

        private DeveloperEntity developerEntity;

        public Builder() {
            this.developerEntity = new DeveloperEntity();
            this.developerEntity.setId(UUID.randomUUID().toString());
        }

        @Override
        public DeveloperEntityBuilder.Email name(String name) {
            this.developerEntity.setName(name);
            return this;
        }

        @Override
        public DeveloperEntityBuilder.Optionals email(String email) {
            this.developerEntity.setEmail(email);
            return this;
        }

        @Override
        public DeveloperEntityBuilder.Optionals yearsOfExperience(int yearsOfExperience) {
            this.developerEntity.setYearsOfExperience(yearsOfExperience);
            return this;
        }

        @Override
        public DeveloperEntity build() {
            return this.developerEntity;
        }
    }

}
