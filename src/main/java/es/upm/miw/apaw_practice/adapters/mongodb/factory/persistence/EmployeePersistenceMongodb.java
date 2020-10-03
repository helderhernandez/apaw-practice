package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.EmployeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.EmployeeCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.EmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeePersistence")
public class EmployeePersistenceMongodb implements EmployeePersistence {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeePersistenceMongodb(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(EmployeeCreation employeeCreation) {
        this.assertDniNotExist(employeeCreation.getDni());
        return this.employeeRepository
                .save(new EmployeeEntity(employeeCreation))
                .toEmployee();
    }

    private void assertDniNotExist(String dni) {
        this.employeeRepository
                .findByDni(dni)
                .ifPresent(employee -> {
                    throw new ConflictException("DNI exist: " + dni);
                });
    }
}
