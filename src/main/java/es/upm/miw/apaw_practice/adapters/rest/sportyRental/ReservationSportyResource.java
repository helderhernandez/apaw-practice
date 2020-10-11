package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.domain.services.sportyRental.ReservationSportyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ReservationSportyResource.RESERVATIONS_SPORTY)
public class ReservationSportyResource {

    static final String RESERVATIONS_SPORTY = "/sportyRental/reservations";
    static final String REF_RESERVATION = "{refReservation}";

    private ReservationSportyService reservationSportyService;

    @DeleteMapping(REF_RESERVATION)
    public void readByRefReservation(@PathVariable String refReservation) {
        this.reservationSportyService.readByRefReservation(refReservation);
    }
}
