package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.EmployeeCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
public class EmployeeEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String lastName;
    private Long phone;
    private LocalDate seniority;
    private BigDecimal salary;
    private String department;


    public EmployeeEntity() {
        // empty for framework
    }

    public static EmployeeBuilders.Dni builder() {
        return new Builder();
    }

    public EmployeeEntity(String dni, String name, String lastName, Long phone, LocalDate seniority, BigDecimal salary, String department) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.seniority = seniority;
        this.salary = salary;
        this.department = department;
    }

    public EmployeeEntity(EmployeeCreation employeeCreation) {
        BeanUtils.copyProperties(employeeCreation, this);
        this.id = UUID.randomUUID().toString();
        this.seniority = LocalDate.now();
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

    public Employee toEmployee() {
        Employee employee = new Employee();
        BeanUtils.copyProperties(this, employee);
        return employee;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (dni.equals(((EmployeeEntity) obj).dni));
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
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

    public static class Builder implements EmployeeBuilders.Dni, EmployeeBuilders.Name, EmployeeBuilders.Optionals {
        private EmployeeEntity employeeEntity;

        public Builder() {
            this.employeeEntity = new EmployeeEntity();
        }

        @Override
        public EmployeeBuilders.Name dni(String dni) {
            this.employeeEntity.dni = dni;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals name(String name) {
            this.employeeEntity.name = name;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals lastName(String lastName) {
            this.employeeEntity.lastName = lastName;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals phone(Long phone) {
            this.employeeEntity.phone = phone;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals seniority(LocalDate seniority) {
            this.employeeEntity.seniority = seniority;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals salary(BigDecimal salary) {
            this.employeeEntity.salary = salary;
            return this;
        }

        @Override
        public EmployeeBuilders.Optionals department(String department) {
            this.employeeEntity.department = department;
            return this;
        }

        @Override
        public EmployeeEntity build() {
            return this.employeeEntity;
        }
    }
}