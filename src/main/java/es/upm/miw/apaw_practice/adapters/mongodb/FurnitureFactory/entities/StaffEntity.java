package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities;


import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

@Document
public class StaffEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer phone;
    private String post;
    private String dni;

    public StaffEntity() {
        // Empty from framework
    }
    public StaffEntity(Staff staff) {
        BeanUtils.copyProperties(staff, this);
        this.id = UUID.randomUUID().toString();
    }
    public Staff toStaff() {
        Staff staff = new Staff();
        BeanUtils.copyProperties(this, staff);
        return staff;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", post='" + post + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public StaffEntity(String firstName, String lastName, Integer age, Integer phone, String post, String dni) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone=phone;
        this.post=post;
        this.dni=dni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity staffEntity = (StaffEntity) o;
        return Objects.equals(id, staffEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
