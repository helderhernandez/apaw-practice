package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Department;
import es.upm.miw.apaw_practice.domain.services.transport.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DepartmentResource.DEPARTMENTS)
public class DepartmentResource {
    static final String DEPARTMENTS = "/transpot/departments";
    static final String NAME_NAME = "/{name}";
    static final String UBICATION = "/ubication";

    private DepartmentService departmentService;

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PutMapping(NAME_NAME + UBICATION)
    public Department updateUbication(@PathVariable String name, @RequestBody UbicationDto ubicationDto) {
        return this.departmentService.updateUbication(name, ubicationDto.getUbication());
    }

}
