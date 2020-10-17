package es.upm.miw.apaw_practice.domain.models.videogame;


public interface GameDeveloperBuilders {
    interface Id {
        Name id(String id);
    }

    interface Name {
        EmailDeveloper name(String name);
    }

    interface EmailDeveloper {
        Phone email(String email);
    }

    interface Phone {
        Build phone(Integer phone);
    }

    interface Build {
        GameDeveloper build();
    }

}
