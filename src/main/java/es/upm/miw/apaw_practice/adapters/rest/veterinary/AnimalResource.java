package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import es.upm.miw.apaw_practice.domain.services.veterinary.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(AnimalResource.ANIMALS)
public class AnimalResource {

    static final String ANIMALS = "/veterinary/animals";

    static final String SEARCH = "/search";
    static final String ID = "/{id}";
    static final String AGE = "/age";

    private final AnimalService animalService;

    @Autowired
    public AnimalResource(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public Stream<Animal> readAll() {
        return this.animalService.readAll();
    }

    @PostMapping
    public Animal create(@RequestBody AnimalCreation animalCreation) {
        return this.animalService.create(animalCreation);
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        this.animalService.delete(id);
    }

    @PutMapping(ID + AGE)
    public Animal updateAge(@PathVariable String id, @RequestBody AgeDto ageDto) {
        return this.animalService.updateAge(id, ageDto.getAge());
    }

    @PatchMapping
    public void updateAges(@RequestBody List<AnimalAgeUpdating> animalAgeUpdatingList) {
        this.animalService.updateAges(animalAgeUpdatingList);
    }
}
