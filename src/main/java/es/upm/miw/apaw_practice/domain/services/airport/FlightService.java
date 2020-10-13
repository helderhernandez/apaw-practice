package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.FlightPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.FlightPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FlightService {

    private FlightPersistence flightPersistence;
    private PassengerPersistence passengerPersistence;

    @Autowired
    public FlightService(FlightPersistence flightPersistence,
                         PassengerPersistence passengerPersistence) {
        this.flightPersistence = flightPersistence;
        this.passengerPersistence = passengerPersistence;
    }

    public Stream<Flight> readAll() {
        return flightPersistence.readAll();
    }

    public void updatePrices(List<FlightPriceUpdating> flightPriceUpdatingList) {
        flightPriceUpdatingList.stream()
                .map(flightNewPrice -> {
                    Flight flight = this.flightPersistence.readById(flightNewPrice.getId());
                    flight.setPrice(flightNewPrice.getPrice());
                    return flight;
                }).forEach(flight -> this.flightPersistence.update(flight));
    }

    public BigDecimal findPriceBySuitcaseColor(String color) {
        return passengerPersistence.findPriceBySuitcaseColor(color);
    }
}
