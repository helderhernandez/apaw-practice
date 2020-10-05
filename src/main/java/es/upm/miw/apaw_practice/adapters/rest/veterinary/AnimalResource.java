package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.services.bank.CustomerService;
import es.upm.miw.apaw_practice.domain.services.veterinary.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(AnimalResource.ANIMALS)
public class AnimalResource {

    static final String ANIMALS = "/veterinary/animals";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";

    private final AnimalService animalService;

    @Autowired
    public AnimalResource(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public Stream<Animal> readAll() {
        return this.animalService.readAll();
    }
}
