package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.EmployeeCreation;
import es.upm.miw.apaw_practice.domain.services.factory.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EmployeeResource.EMPLOYEES)
public class EmployeeResource {

    static final String EMPLOYEES = "/factory/employees";

    private EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeCreation employeeCreation) {
        return this.employeeService.create(employeeCreation);
    }
}
