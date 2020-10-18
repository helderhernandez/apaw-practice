package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import java.time.LocalDateTime;

public interface RunnerClubBuilders {

    interface Id {
        Name id(String id);
    }

    interface Name {
        Location name(String name);
    }

    interface Location {
        FoundationDate location(String location);
    }

    interface FoundationDate {
        RunnerClubBuilder foundationDate(LocalDateTime foundationDate);
    }

    interface RunnerClubBuilder {
        RunnerClubEntity build();
    }
}
