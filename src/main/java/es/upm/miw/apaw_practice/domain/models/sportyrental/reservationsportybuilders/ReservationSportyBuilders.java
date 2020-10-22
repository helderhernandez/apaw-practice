package es.upm.miw.apaw_practice.domain.models.sportyrental.reservationsportybuilders;

import es.upm.miw.apaw_practice.domain.models.sportyrental.CategorySporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CustomerSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.ReservationSporty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationSportyBuilders {

    interface IdReservation {
        DateReservation idReservation(String idReservation);
    }

    interface DateReservation {
        RefReservation dateReservation(LocalDateTime dateReservation);
    }

    interface RefReservation {
        Optionals refReservation(String refReservation);
    }

    interface Optionals {
        ReservationSportyBuilders.Optionals amount(BigDecimal amount);

        ReservationSportyBuilders.Optionals paidOut(Boolean paidOut);

        ReservationSportyBuilders.Optionals listCustomersSporty(List<CustomerSporty> customersSporty);

        ReservationSportyBuilders.Optionals categorySporty(CategorySporty categorySporty);

        ReservationSportyBuilders.Optionals listDiscountsSporty(List<DiscountSporty> discountsSporty);

        ReservationSporty build();
    }
}
