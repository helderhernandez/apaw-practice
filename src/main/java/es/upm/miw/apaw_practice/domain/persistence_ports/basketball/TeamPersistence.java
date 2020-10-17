package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TeamPersistence {

    void deleteById(String id);

    Stream<String> findNameCourtsByTeamName(String name);

}
