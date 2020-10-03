package es.upm.miw.apaw_practice.domain.services.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.EmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeePersistence employeePersistence;

    @Autowired

    public EmployeeService(EmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }

    public Employee create(Employee employee) {
        return this.employeePersistence.create(employee);
    }

}
