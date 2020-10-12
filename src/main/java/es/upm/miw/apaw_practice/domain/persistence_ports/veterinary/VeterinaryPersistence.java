package es.upm.miw.apaw_practice.domain.persistence_ports.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Veterinary;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface VeterinaryPersistence {

    Stream<Veterinary> readAll();

    Veterinary readById(String id);

}
