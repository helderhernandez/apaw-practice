package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;


import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.services.FurnitureFactory.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(FurnitureResource.FURNITURE)
public class FurnitureResource {
    static final String FURNITURE = "/FurnitureFactory/furniture";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";
    static final String NAME = "/name";

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureResource(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public Stream<Furniture> readAll() {
        return this.furnitureService.readAll();
    }
    @PutMapping(ID_ID + NAME)
    public Furniture updateName(@PathVariable String id, @RequestBody NameDto nameDto) {
        return this.furnitureService.updateName(id, nameDto.getName());
    }

}
