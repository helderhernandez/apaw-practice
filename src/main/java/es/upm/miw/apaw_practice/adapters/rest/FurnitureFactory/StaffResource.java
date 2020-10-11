package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.services.FurnitureFactory.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(StaffResource.STAFF)
public class StaffResource {
    static final String STAFF = "/FurnitureFactory/staff";

    static final String SEARCH = "/search";

    private final StaffService staffService;

    @Autowired
    public StaffResource(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return this.staffService.create(staff);
    }
}
