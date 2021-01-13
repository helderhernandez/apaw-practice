package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class AppointmentEntityRepositoryIT {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(
            this.appointmentRepository
                .findAll()
                .stream()
                .anyMatch(appointment->
                        appointment.getActive().equals(Boolean.TRUE) &&
                        appointment.getDate().equals(LocalDateTime.of(2021, 2, 1, 11, 0)) &&
                        appointment.getDesignEntity().getType().equals("single") &&
                        appointment.getDesignEntity().getStyle().equals("Blackwork") &&
                        appointment.getDesignEntity().getFinished().equals(Boolean.FALSE) &&
                        appointment.getDesignEntity().getCost().equals(new BigDecimal("300.00"))
        ));
    }
}
