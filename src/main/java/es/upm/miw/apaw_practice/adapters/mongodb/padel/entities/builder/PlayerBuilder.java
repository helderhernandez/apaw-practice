package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.builder;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.ReservationEntity;

public interface PlayerBuilder {
    interface Name{
        Surname name(String name);
    }
    interface Surname {
        Dni surname(String surname);
    }
    interface Dni {
        Email dni (String dni);
    }
    interface Email {
        Federated email(String email);
    }
    interface Federated {
        ReservationEntities federated(Boolean federated);
    }
    interface ReservationEntities {
        ReservationEntities reservationEntities(ReservationEntity reservationEntity);
        Build endReservationEntities();

    }
    interface Build {
        PlayerEntity build();
    }
}
