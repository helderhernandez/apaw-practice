package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CDEmployee {
    private String id;
    private String name;
    private String category;
    private LocalDateTime seniority;
    private BigDecimal salary;

    public CDEmployee() {
        // Empty for framework
    }

    public CDEmployee(String id, String name, String category, LocalDateTime seniority, BigDecimal salary) {
        this.id = id;
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
    public String toString() {
        return "CDEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", seniority=" + seniority +
                ", salary=" + salary +
                '}';
    }
}
