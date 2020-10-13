package es.upm.miw.apaw_practice.adapters.mongodb.property.entities;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class ProprietorEntity {
    private String name;
    private String dni;
    private String age;
    private String phone;
    private String email;

    public ProprietorEntity(){
        //empty from framework
    }

    public ProprietorEntity(String name, String dni, String age, String phone, String email) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Proprietor toProprietor() {
        Proprietor proprietor = new Proprietor();
        BeanUtils.copyProperties(this, proprietor);
        return proprietor; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietorEntity that = (ProprietorEntity) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "ProprietorEntity{" +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

}
