package es.upm.miw.apaw_practice.adapters.mongodb.studio.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.AppointmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.AppointmentEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.AppointmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public void updateIsActiveFlags(Boolean isActive) {
        List<AppointmentEntity> appointments = this.appointmentRepository
                .findAll()
                .stream()
                .map(appointment -> {
                   appointment.setActive(isActive);
                   return appointment;
                }).collect(Collectors.toList());
        this.appointmentRepository.saveAll(appointments);
    }

    @Override
    public Stream<String> getIdsAppointmentByTattoistName(String name) {
        return appointmentRepository
                .findAll()
                .stream()
                .filter(appointmentEntity -> appointmentEntity
                        .getDesignEntity()
                        .getTattoistEntities()
                        .stream()
                        .anyMatch(tattoistEntity -> tattoistEntity.getName().equals(name))
                ).map(AppointmentEntity::getId);
    }
}
