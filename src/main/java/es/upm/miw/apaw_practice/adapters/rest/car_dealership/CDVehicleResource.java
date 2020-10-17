package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CDVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Stream;

@RestController
@RequestMapping(CDVehicleResource.VEHICLES)
public class CDVehicleResource {
    static final String VEHICLES = "/car-dealership/vehicles";
    static final String FRAME_FRAME = "/{frame}";
    static final String BRAND = "/brand";
    static final String SEARCH = "/search";

    private CDVehicleService vehicleService;

    @Autowired
    public CDVehicleResource(CDVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public CDVehicle create(@RequestBody CDVehicleCreation vehicleCreation) {
        return this.vehicleService.create(vehicleCreation);
    }

    @PutMapping(FRAME_FRAME + BRAND)
    public CDVehicle updateBrand(@PathVariable String frame, @RequestBody CDBrandDto brandDto) {
        return this.vehicleService.updateBrand(frame, brandDto.getBrand());
    }

    @GetMapping(SEARCH)
    public Stream<String>  findBrandsByEmployeeName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.vehicleService.findBrandsByEmployeeName(name);
    }

}
