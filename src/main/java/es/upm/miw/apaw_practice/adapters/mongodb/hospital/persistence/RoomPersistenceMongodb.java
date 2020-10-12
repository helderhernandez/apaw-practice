package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.RoomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.RoomEntity;
import es.upm.miw.apaw_practice.domain.models.hospital.Room;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.RoomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("roomPersistence")
public class RoomPersistenceMongodb implements RoomPersistence {
    
    private RoomRepository roomRepository;
    
    @Autowired
    public RoomPersistenceMongodb(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }
    
    @Override
    public void deleteById(String id){
        this.roomRepository.deleteById(id);
    }

    @Override
    public Stream<Room> findRoomsByPatientsIllnessContagious(Boolean contagious) {
        return this.roomRepository.findAll().stream()
                .filter(roomEntity -> roomEntity.getPatientEntities().stream()
                        .flatMap(patientEntity -> patientEntity.getIllnessEntities().stream())
                        .anyMatch(illnessEntity -> illnessEntity.getContagious().equals(contagious)))
                .map(RoomEntity::toRoom);
    }
}
