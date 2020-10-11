package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerPersistence {

    Worker read(String dni);

    List<String> findByDepartmentName(String name);

}
