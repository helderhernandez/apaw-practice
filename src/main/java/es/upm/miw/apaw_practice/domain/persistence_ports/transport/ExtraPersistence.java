package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface ExtraPersistence {

    Extra update(Extra extra);

    Extra findById(String id);

    Stream<Extra> readAll();

    void deleteById(String id);

    Stream<Integer> readWorkedHoursByWorker(List<String> listofWorkers);

}
