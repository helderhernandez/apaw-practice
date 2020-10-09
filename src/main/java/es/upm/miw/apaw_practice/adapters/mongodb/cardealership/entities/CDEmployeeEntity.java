package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class CDEmployeeEntity {
    @Id
    private String id;
    private String name;
    private String category;
    private LocalDateTime seniority;
    private BigDecimal salary;

    public CDEmployeeEntity() {
        // Empty for framework
    }

    public CDEmployeeEntity(String name, String category, LocalDateTime seniority, BigDecimal salary) {
        this.name = name;
        this.category = category;
        this.seniority = seniority;
        this.salary = salary;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CDEmployeeEntity that = (CDEmployeeEntity) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "CDEmployeeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", seniority=" + seniority +
                ", salary=" + salary +
                '}';
    }
}
