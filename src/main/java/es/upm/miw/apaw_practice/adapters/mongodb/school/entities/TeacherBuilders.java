package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

public interface TeacherBuilders {
    interface Name {
        FamilyName name(String name);
    }

    interface FamilyName {
        Dni familyName(String familyName);
    }

    interface Dni {
        Optionals dni(String dni);
    }

    interface Optionals {
        Optionals intern(Boolean intern);

        Optionals email(String email);

        TeacherEntity build();

    }
}
