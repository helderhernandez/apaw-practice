package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DepartmentEntityRepositoryIT {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testModifyAndRead() {
        assertTrue(this.departmentRepository.findAll().stream()
                .anyMatch(department ->
                        "name1".equals(department.getName()) &&
                                "ubication1".equals(department.getUbication()) &&
                                department.getWorkerEntityList().get(0).getName().equals("name1")));
    }
}
