package es.upm.miw.apaw_practice.domain.models.factory;

import java.math.BigDecimal;

public class EmployeeCreation {
    private String dni;
    private String name;
    private String lastName;
    private Long phone;
    private BigDecimal salary;
    private String department;

    public EmployeeCreation() {
        //empty for framework
    }

    public EmployeeCreation(String dni, String name, String lastName, Long phone, BigDecimal salary, String department) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
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
        return "EmployeeCreation{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
