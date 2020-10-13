package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDEmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
