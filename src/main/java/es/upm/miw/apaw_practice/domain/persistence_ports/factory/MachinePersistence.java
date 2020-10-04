package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Machine;

public interface MachinePersistence {
    Machine updateStatus(String id, Boolean status);
}
