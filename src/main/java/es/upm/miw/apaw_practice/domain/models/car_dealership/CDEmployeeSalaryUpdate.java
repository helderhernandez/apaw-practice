package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.math.BigDecimal;

public class CDEmployeeSalaryUpdate {
    private String id;
    private BigDecimal salary;

    public CDEmployeeSalaryUpdate() {
        // Empty for framework
    }

    public CDEmployeeSalaryUpdate(String id, BigDecimal salary) {
        this.id = id;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CDEmployeeSalaryUpdate{" +
                "salary=" + salary +
                '}';
    }
}
