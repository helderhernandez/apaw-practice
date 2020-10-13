package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Court;

public interface CourtPersistence {
    Court updateCapacity(String id, Integer capacity);
}
