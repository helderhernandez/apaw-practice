package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ExtraPersistence {

    Extra update(Extra extra);

    Extra findById(String id);

    Stream<Extra> readAll();

    void deleteById(String id);
}
