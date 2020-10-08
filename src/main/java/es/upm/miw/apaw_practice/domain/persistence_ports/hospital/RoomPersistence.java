package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Room;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RoomPersistence {

    void deleteById(String id);

    Stream<Room> findRoomsByPatientsIllnessContagious(Boolean contagious);
}
