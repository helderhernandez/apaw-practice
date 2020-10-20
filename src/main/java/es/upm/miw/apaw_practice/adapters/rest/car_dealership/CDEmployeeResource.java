package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployeeSalaryUpdate;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CDEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping
    public void updatePrices(@RequestBody List<CDEmployeeSalaryUpdate> employeeSalaryUpdates) {
        this.employeeService.updateSalaries(employeeSalaryUpdates);
    }

}
