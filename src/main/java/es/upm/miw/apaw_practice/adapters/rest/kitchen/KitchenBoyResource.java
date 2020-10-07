package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.domain.services.kitchen.KitchenBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(KitchenBoyResource.KITCHEN_BOY)
public class KitchenBoyResource {
    static final String KITCHEN_BOY = "/kitchen/kitchen_boy";
    static final String DNI = "/{dni}";

    private KitchenBoyService kitchenBoyService;

    @Autowired
    public KitchenBoyResource(KitchenBoyService kitchenBoyService) {
        this.kitchenBoyService = kitchenBoyService;
    }

    @DeleteMapping(DNI)
    public void delete(@PathVariable String dni) {
        this.kitchenBoyService.delete(dni);
    }
}
