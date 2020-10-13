package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDEmployeeRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDEmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cDEmployeePersistence")
public class CDEmployeePersistenceMongodb implements CDEmployeePersistence {

    private CDEmployeeRepository employeeRepository;

    @Autowired
    public CDEmployeePersistenceMongodb(CDEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void deleteById(String id) {
        this.employeeRepository.deleteById(id);
    }
}
