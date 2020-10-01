package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class EmployeeEntity {

    @Id
    private String id;
    private Long phoneNumber;
    private LocalDateTime seniority;
    private BigDecimal salary;
    private String department;
    private String category;

    public EmployeeEntity() {
        // empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getSeniority() {
        return seniority;
    }

    public void setSeniority(LocalDateTime seniority) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (id.equals(((EmployeeEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id='" + id + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", seniority=" + seniority +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}