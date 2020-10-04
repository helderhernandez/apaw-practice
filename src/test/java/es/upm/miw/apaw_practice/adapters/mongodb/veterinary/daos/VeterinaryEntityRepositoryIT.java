package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class VeterinaryEntityRepositoryIT {

    @Autowired
    private VeterinaryRepository veterinaryRepository;

    @Test
    void testAndCreate() {
        assertTrue(this.veterinaryRepository.findAll().stream()
                .anyMatch(veterinary ->
                        "key-vet-365".equals(veterinary.getId()) &&
                                "Sonsoles".equals(veterinary.getName()) &&
                                42 == veterinary.getAge())
        );
    }
}
