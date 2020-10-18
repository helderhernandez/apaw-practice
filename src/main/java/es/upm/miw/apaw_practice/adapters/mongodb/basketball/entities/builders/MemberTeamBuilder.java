package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.builders;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;

public interface MemberTeamBuilder {

    interface Name {
        Surname name(String name);
    }

    interface Surname {
        Dni surname(String surname);
    }

    interface Dni {
        Available dni(String dni);
    }

    interface Available {
         BuildMember available(Boolean available);
    }

    interface BuildMember {
        MemberTeamEntity build();
    }
}
