package es.upm.miw.apaw_practice.domain.services.studio;

import es.upm.miw.apaw_practice.domain.persistence_ports.studio.AppointmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final AppointmentPersistence appointmentPersistence;

    @Autowired
    public AppointmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public void delete(String id) {
        this.appointmentPersistence.deleteById(id);
    }

    public void updateIsActiveFlags(Boolean isActive) {
        this.appointmentPersistence.updateIsActiveFlags(isActive);
    }

    public void getIdsAppointmentByTattoistName(String name) {
        this.appointmentPersistence.getIdsAppointmentByTattoistName(name);
    }
}
