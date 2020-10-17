package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import es.upm.miw.apaw_practice.domain.services.transport.VehicleTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(VehicleTransportResource.VEHICLES)
public class VehicleTransportResource {
    static final String VEHICLES = "/transport/vehicles";
    static final String SEARCH = "/search";

    private final VehicleTransportService vehicleTransportService;

    @Autowired
    public VehicleTransportResource(VehicleTransportService vehicleTransportService) {
        this.vehicleTransportService = vehicleTransportService;
    }

    @PostMapping
    public VehicleTransport create(@RequestBody VehicleTransport vehicleTransport) {
        return this.vehicleTransportService.create(vehicleTransport);
    }

    @GetMapping(SEARCH)
    public Stream<DistinctModelVehicleDto> searchDistinctModelByDepartment(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.vehicleTransportService.searchDistinctModelByDepartment(name)
                .map(DistinctModelVehicleDto::new);
    }
}
