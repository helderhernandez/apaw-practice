package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Employee;

public interface EmployeePersistence {
    Employee create(Employee employee);
}
