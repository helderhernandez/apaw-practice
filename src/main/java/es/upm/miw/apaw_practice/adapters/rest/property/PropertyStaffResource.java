package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import es.upm.miw.apaw_practice.domain.services.property.PropertyStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PropertyStaffResource.STAFFS)
public class PropertyStaffResource {
    static final String STAFFS = "/property/staffs";
    static final String SEARCH = "/search";

    private final PropertyStaffService propertyStaffService;

    @Autowired
    public PropertyStaffResource(PropertyStaffService propertyStaffService) {
        this.propertyStaffService = propertyStaffService;
    }

    @PostMapping
    public PropertyStaff create(@RequestBody PropertyStaffCreation propertyStaffCreation) {
        return this.propertyStaffService.create(propertyStaffCreation);
    }
}
