package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.domain.services.transittaxes.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OwnerResource.OWNERS)
public class OwnerResource {
    static final String OWNERS = "/transittaxes/owners";
    static final String ID_ID = "/{id}";

    private OwnerService ownerService;

    @Autowired
    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.ownerService.delete(id);
    }
}
