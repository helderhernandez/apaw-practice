package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.domain.services.property.MaintanenceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MaintanenceItemResource.ITEMS)
public class MaintanenceItemResource {
    static final String ITEMS = "/property/items";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private final MaintanenceItemService maintanenceItemService;

    @Autowired
    public MaintanenceItemResource(MaintanenceItemService maintanenceItemService) {
        this.maintanenceItemService = maintanenceItemService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.maintanenceItemService.delete(id);
    }
}