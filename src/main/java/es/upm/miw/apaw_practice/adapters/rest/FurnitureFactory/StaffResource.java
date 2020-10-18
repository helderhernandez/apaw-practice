package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.services.FurnitureFactory.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

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
    @GetMapping(SEARCH)
    public Stream<Staff> findFirstNameByWarehouseName(@RequestParam String q) {
        String warehouseName = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.staffService.findFirstNameByWarehouseName(warehouseName);
    }
}
