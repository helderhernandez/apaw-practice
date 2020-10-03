package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class MortgageEntityRepositoryIT {

    @Autowired
    private MortgageRepository mortgageRepository;

    @Test
    void testAndCreate() {
        assertTrue(this.mortgageRepository.findAll().stream()
                .anyMatch(mortgage ->
                        new BigDecimal("5000.00").equals(mortgage.getAmount()) &&
                                new BigDecimal("200.00").equals(mortgage.getPaidout()) &&
                                mortgage.getId() != null &&
                                "511511511L".equals(mortgage.getCustomerEntity().getDNI()) &&
                                "Ulises".equals(mortgage.getCustomerEntity().getName()) &&
                                "666777888".equals(mortgage.getCustomerEntity().getPhone()) &&
                                "ulises@email.com".equals(mortgage.getCustomerEntity().getEmail())
                )
        );
    }

}
