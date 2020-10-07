package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefResource {
    static final String CHEF = "/kitchen/chef";
    static final String DNI = "/{dni}";

    private ChefService chefService;

    @Autowired
    public ChefResource(ChefService chefService) {
        this.chefService = chefService;
    }

    @PutMapping(DNI)
    public Chef updateName(@PathVariable String dni, @PathVariable String name) {
        return this.chefService.updateName(dni, name);
    }

}
