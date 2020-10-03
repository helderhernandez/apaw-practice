package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.EmployeeCreation;

public interface EmployeePersistence {
    Employee create(EmployeeCreation employeeCreation);
}
