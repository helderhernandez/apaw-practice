package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.services.sportyRental.ReservationSportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ReservationSportyResource.RESERVATIONS_SPORTY)
public class ReservationSportyResource {

    static final String RESERVATIONS_SPORTY = "/sportyRental/reservations";
    static final String REF_RESERVATION = "/{refReservation}";

    private ReservationSportyService reservationSportyService;

    @Autowired
    public ReservationSportyResource(ReservationSportyService reservationSportyService) {
        this.reservationSportyService = reservationSportyService;
    }

    @GetMapping(REF_RESERVATION)
    public ReservationSporty readByRefReservation(@PathVariable String refReservation) {
        return this.reservationSportyService.readByRefReservation(refReservation);
    }

    @PostMapping
    public ReservationSporty create(@RequestBody ReservationCreationSporty reservationSportyCreation) {
        return this.reservationSportyService.create(reservationSportyCreation);
    }

}
