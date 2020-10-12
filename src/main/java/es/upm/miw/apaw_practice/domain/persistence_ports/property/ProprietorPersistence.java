package es.upm.miw.apaw_practice.domain.persistence_ports.property;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProprietorPersistence {
    Stream <Proprietor> readAll();

}