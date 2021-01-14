package es.upm.miw.apaw_practice.domain.persistence_ports.studio;

import java.util.stream.Stream;

public interface AppointmentPersistence {
    void deleteById(String id);

    void updateIsActiveFlags(Boolean isActive);

    Stream<String> getIdsAppointmentByTattoistName(String name);
}
