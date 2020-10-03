package es.upm.miw.apaw_practice.domain.models.factory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private String id;
    private String dni;
    private String name;
    private String lastName;
    private Long phone;
    private LocalDate seniority;
    private BigDecimal salary;
    private String department;

    public Employee() {
        // empty for framework
    }

    public Employee(String dni, String name, String lastName, Long phone, LocalDate seniority, BigDecimal salary, String department) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.seniority = seniority;
        this.salary = salary;
        this.department = department;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDate getSeniority() {
        return seniority;
    }

    public void setSeniority(LocalDate seniority) {
        this.seniority = seniority;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", seniority=" + seniority +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
