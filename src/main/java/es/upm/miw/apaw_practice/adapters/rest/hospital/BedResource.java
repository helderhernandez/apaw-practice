package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import es.upm.miw.apaw_practice.domain.services.hospital.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(BedResource.BEDS)
public class BedResource {
    static final String BEDS = "/hospital/beds";
    static final String ID_ID = "/{id}";;
    static final String OCCUPIED = "/occupied";

    private BedService bedService;

    @Autowired
    public BedResource(BedService bedService){
        this.bedService=bedService;
    }

    @PutMapping(ID_ID + OCCUPIED)
    public Bed updateOccupied(@PathVariable String id, @RequestBody Boolean occupied) {
        return this.bedService.updateOccupied(id, occupied);
    }
}
