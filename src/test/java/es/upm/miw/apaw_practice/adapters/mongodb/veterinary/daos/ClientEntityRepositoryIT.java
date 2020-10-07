package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ClientEntityRepositoryIT {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testAndCreate() {
        assertTrue(this.clientRepository.findAll().stream()
                .anyMatch(client ->
                        "key-client-ds".equals(client.getId()) &&
                                "Manuel".equals(client.getName()) &&
                                "calle Lazaga".equals(client.getAddress()) &&
                                "636363654".equals(client.getPhone()))
        );
    }
}
