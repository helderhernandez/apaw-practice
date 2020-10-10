package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface EmployeeBuilders {

    interface Dni {
        Name dni(String dni);
    }

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals lastName(String lastName);

        Optionals phone(Long phone);

        Optionals seniority(LocalDate seniority);

        Optionals salary(BigDecimal salary);

        Optionals department(String department);

        EmployeeEntity build();
    }
}

