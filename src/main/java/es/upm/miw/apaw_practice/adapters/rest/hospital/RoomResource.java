package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.services.hospital.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoomResource.ROOMS)
public class RoomResource {
    static final String ROOMS = "/hospital/rooms";
    static final String ID_ID = "/{id}";

    private RoomService roomService;
    
    @Autowired

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }
    
    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id){
        this.roomService.delete(id);
    }
}
