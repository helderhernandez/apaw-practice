package es.upm.miw.apaw_practice.adapters.mongodb.studio.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.AppointmentRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.AppointmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("appointmentPersistence")
public class AppointmentPersistenceMongodb implements AppointmentPersistence {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentPersistenceMongodb(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void deleteById(String id) {
        this.appointmentRepository.deleteById(id);
    }
}
