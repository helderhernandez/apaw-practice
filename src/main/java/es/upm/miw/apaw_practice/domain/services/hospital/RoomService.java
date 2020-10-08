package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.adapters.rest.hospital.WidthDto;
import es.upm.miw.apaw_practice.domain.models.hospital.Room;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.RoomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class RoomService {
    
    private RoomPersistence roomPersistence;

    @Autowired
    public RoomService(RoomPersistence roomPersistence) {
        this.roomPersistence = roomPersistence;
    }
    
    public void delete(String id){
        this.roomPersistence.deleteById(id);
    }

    public Stream<Room> findRoomsByPatientsIllnessContagious(Boolean contagious) {
        return this.roomPersistence.findRoomsByPatientsIllnessContagious(contagious);
    }
}
