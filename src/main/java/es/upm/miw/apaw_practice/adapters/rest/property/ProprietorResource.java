package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.models.property.ProprietorEmailUpdating;
import es.upm.miw.apaw_practice.domain.services.property.ProprietorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(ProprietorResource.PROPRIETORS)

public class ProprietorResource {
    static final String PROPRIETORS = "/property/proprietors";
    static final String SEARCH = "/search";
    static final String DNI_DNI = "/{dni}";


    private final ProprietorService proprietorService;

    @Autowired
    public ProprietorResource(ProprietorService proprietorService) {
        this.proprietorService = proprietorService;
    }

    @GetMapping
    public Stream<Proprietor> readAll() {
        return this.proprietorService.readAll();
    }

    @PatchMapping
    public void updateProprietors(@RequestBody List<ProprietorEmailUpdating> proprietorEmailUpdatingList) {
        this.proprietorService.updateEmail(proprietorEmailUpdatingList);
    }
}