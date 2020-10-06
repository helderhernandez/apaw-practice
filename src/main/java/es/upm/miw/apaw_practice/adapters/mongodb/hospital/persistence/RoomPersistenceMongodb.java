package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.RoomRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.RoomPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
