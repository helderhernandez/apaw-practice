package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.services.property.ProprietorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(ProprietorResource.PROPRIETORS)

public class ProprietorResource {
    static final String PROPRIETORS = "/property/proprietors";

    static final String SEARCH = "/search";

    private ProprietorService proprietorService;

    @Autowired
    public ProprietorResource(ProprietorService proprietorService) {
        this.proprietorService = proprietorService;
    }

    @GetMapping
    public Stream<Proprietor> readAll() {
        return this.proprietorService.readAll();
    }
}