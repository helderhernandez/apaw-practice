package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Department;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DepartmentPersistence {
    Stream<Department> readAll();

    Department update(Department department);

    Department updateUbication(String name, String ubication);
}
