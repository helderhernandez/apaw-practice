package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.domain.services.FurnitureFactory.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(AddressResource.ADDRESS)
public class AddressResource {
    static final String ADDRESS = "/FurnitureFactory/address";

    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private final AddressService addressService;

    @Autowired
    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.addressService.delete(id);
    }

}