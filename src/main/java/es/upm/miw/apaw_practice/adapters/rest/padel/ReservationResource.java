package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.domain.models.Reservation.Reservation;
import es.upm.miw.apaw_practice.domain.services.padel.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(ReservationResource.RESERVATIONS)
public class ReservationResource {
    static final String RESERVATIONS = "/padel/reservations";

    private ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public Stream<Reservation> readAll(){
        return this.reservationService.readAll();
    }
}
