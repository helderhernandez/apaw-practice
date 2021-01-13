package es.upm.miw.apaw_practice.domain.persistence_ports.studio;

public interface AppointmentPersistence {
    void deleteById(String id);

    void updateIsActiveFlags(Boolean isActive);
}
