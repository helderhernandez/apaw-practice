package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Machine;

import java.util.List;

public interface MachinePersistence {
    Machine updateStatus(String id, Boolean isActive);

    List<Machine> findMachineByEmployeeDegreeTitle(String title);

}
