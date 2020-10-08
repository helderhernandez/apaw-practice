package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.DegreeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DegreeEntityRepositoryIT {

    @Autowired
    private DegreeRepository degreeRepository;

    @Test
    void testFindByRecordNumber() {
        assertTrue(this.degreeRepository.findByRecordNumber("123456-7").isPresent());
        DegreeEntity degree = this.degreeRepository.findByRecordNumber("123456-7").get();
        assertEquals("Grado en Ingenieria de Telecomunicaciones", degree.getTitle());
        assertEquals("123456-7", degree.getRecordNumber());
        assertEquals("Universidad de Alcala", degree.getInstitute());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.degreeRepository.findAll().stream()
                .anyMatch(deg ->
                        "Grado en Ingenieria Industrial".equals(deg.getTitle()) &&
                                "Universidad Carlos III de Madrid".equals(deg.getInstitute()) &&
                                deg.getId() != null &&
                                "22222222C".equals(deg.getEmployeeEntity().getDni()) &&
                                LocalDate.of(2018, 7, 27).equals(deg.getEmployeeEntity().getSeniority()) &&
                                666666662L == deg.getEmployeeEntity().getPhone()
                ));
    }

}
