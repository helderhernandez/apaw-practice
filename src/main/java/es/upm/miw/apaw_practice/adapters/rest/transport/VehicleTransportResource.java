package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import es.upm.miw.apaw_practice.domain.services.transport.VehicleTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VehicleTransportResource.VEHICLES)
public class VehicleTransportResource {
    static final String VEHICLES = "/transport/vehicles";

    private VehicleTransportService vehicleTransportService;

    @Autowired
    public VehicleTransportResource(VehicleTransportService vehicleTransportService) {
        this.vehicleTransportService = vehicleTransportService;
    }

    @PostMapping
    public VehicleTransport create(@RequestBody VehicleTransport vehicleTransport) {
        return this.vehicleTransportService.create(vehicleTransport);
    }

}
