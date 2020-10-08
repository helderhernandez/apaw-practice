package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

public interface SpecialityBuilders {

    interface Id {
        Title id(String id);
    }

    interface Title {
        Description title(String title);
    }

    interface Description {
        Duration description(String description);
    }

    interface Duration {
        Recomended duration(Integer duration);
    }

    interface Recomended {
        Optionals recomended(Boolean recomended);
    }

    interface Optionals {
        SpecialityEntity build();
    }


}
