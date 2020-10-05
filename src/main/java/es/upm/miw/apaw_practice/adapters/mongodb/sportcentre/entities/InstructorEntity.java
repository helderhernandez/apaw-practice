package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;


import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class InstructorEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String lastName;
    private BigDecimal salary;
    @DBRef
    private List<SpecialityEntity> specialities;

    public InstructorEntity(){
        //Empty from framework
    }

    public InstructorEntity(InstructorCreation instructorCreation) {
        BeanUtils.copyProperties(instructorCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<SpecialityEntity> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<SpecialityEntity> specialities) {
        this.specialities = specialities;
    }

    public Instructor toInstructor() {
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(this, instructor);
        return instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorEntity that = (InstructorEntity) o;
        return id.equals(that.id) &&
                dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }

    @Override
    public String toString() {
        return "InstructorEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", specialities=" + specialities +
                '}';
    }
}
