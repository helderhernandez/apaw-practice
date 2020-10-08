package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Department;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.DepartmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentPersistence departmentPersistence;

    @Autowired
    public DepartmentService(DepartmentPersistence departmentPersistence) {
        this.departmentPersistence = departmentPersistence;
    }

    public Department updateUbication(String name, String ubication){
        return this.departmentPersistence.updateUbication(name, ubication);
}
}
