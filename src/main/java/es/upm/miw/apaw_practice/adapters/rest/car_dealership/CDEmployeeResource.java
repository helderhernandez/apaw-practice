package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.services.car_dealership.CDEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CDEmployeeResource.EMPLOYEES)
public class CDEmployeeResource {
    static final String EMPLOYEES = "/car-dealership/employees";
    static final String ID_ID = "/{id}";

    private CDEmployeeService employeeService;

    @Autowired
    public CDEmployeeResource(CDEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.employeeService.delete(id);
    }

}
