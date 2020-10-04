package es.upm.miw.apaw_practice.domain.models.sportcentre;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;

import java.math.BigDecimal;
import java.util.List;

public class InstructorCreation {

    private String dni;
    private String name;
    private String lastName;
    private BigDecimal salary;
    private List<Speciality> specialities;

    public InstructorCreation(){
        //Empty from framework
    }

    public InstructorCreation(String dni, String name, String lastName, BigDecimal salary, List<Speciality> specialities) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.specialities = specialities;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String id) {
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

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return "InstructorCreation{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", specialities=" + specialities +
                '}';
    }
}
