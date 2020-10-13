package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import es.upm.miw.apaw_practice.domain.services.garage.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@RestController
@RequestMapping(MechanicResource.MECHANICS)
public class MechanicResource {
    static final String MECHANICS = "/garage/mechanics";

    private MechanicService mechanicService;

    @Autowired
    public MechanicResource(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping
    public Stream<Mechanic> readAll() {
        return this.mechanicService.readAll();
    }

}
