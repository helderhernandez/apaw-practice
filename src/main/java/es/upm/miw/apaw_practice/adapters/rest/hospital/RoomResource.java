package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.hospital.Room;
import es.upm.miw.apaw_practice.domain.services.hospital.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(RoomResource.ROOMS)
public class RoomResource {
    static final String ROOMS = "/hospital/rooms";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";


    private RoomService roomService;
    
    @Autowired

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }
    
    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id){
        this.roomService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<Room> findRoomsByPatientsIllnessContagious(@RequestParam String q) {
        Boolean contagious = new LexicalAnalyzer().extractWithAssure(q, "contagious",Boolean::new);
        return this.roomService.findRoomsByPatientsIllnessContagious(contagious);
    }
}
