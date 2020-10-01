package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentEntity {
    @Id
    private String id;
    private String name;
    private String familyName;
    private boolean graduate;
    @Indexed(unique = true)
    private String dni;
    private String email;

    public StudentEntity() {
        //empty from framework
    }

    public StudentEntity(String name, String familyName, boolean graduate, String dni, String email) {
        this.name = name;
        this.familyName = familyName;
        this.graduate = graduate;
        this.dni = dni;
        this.email = email;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public boolean isGraduate() {
        return graduate;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
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

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", graduate=" + graduate +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

