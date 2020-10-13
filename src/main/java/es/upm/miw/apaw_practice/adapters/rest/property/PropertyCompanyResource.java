package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyCompany;
import es.upm.miw.apaw_practice.domain.services.property.PropertyCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(PropertyCompanyResource.COMPANIES)
public class PropertyCompanyResource {
    static final String COMPANIES = "/property/companies";
    static final String SEARCH = "/search";

    static final String NAME = "/name";

    private final PropertyCompanyService propertyCompanyService;

    @Autowired
    public PropertyCompanyResource(PropertyCompanyService propertyCompanyService) {
        this.propertyCompanyService = propertyCompanyService;
    }

    @PutMapping(NAME)
    public PropertyCompany updateName(@RequestBody NameDto nameDto) {
        return this.propertyCompanyService.updateName(nameDto.getName());
    }

    @GetMapping
    public Stream<PropertyCompany> readAll() {
        return this.propertyCompanyService.readAll();
    }
}