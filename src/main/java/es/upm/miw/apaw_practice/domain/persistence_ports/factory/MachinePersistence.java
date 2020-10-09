package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Machine;

import java.util.stream.Stream;

public interface MachinePersistence {
    Machine updateStatus(String id, Boolean active);

    Stream<Machine> findMachineByEmployeeDegreeTitle(String title);

}
