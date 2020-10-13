package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployee;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployeeSalaryUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDEmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDEmployeeService {
    private CDEmployeePersistence employeePersistence;

    @Autowired
    public CDEmployeeService(CDEmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }

    public void delete(String id) {
        this.employeePersistence.deleteById(id);
    }

    public void updateSalaries(List<CDEmployeeSalaryUpdate> employeeSalaryUpdates) {
        employeeSalaryUpdates.stream()
                .map(employeeNewSalary -> {
                    CDEmployee employee = this.employeePersistence.readById(employeeNewSalary.getId());
                    employee.setSalary(employeeNewSalary.getSalary());
                    return employee;
                })
                .forEach(employee -> this.employeePersistence.update(employee));
    }
}
