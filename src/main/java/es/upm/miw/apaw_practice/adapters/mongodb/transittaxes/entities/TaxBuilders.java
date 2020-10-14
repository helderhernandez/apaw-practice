package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;


import java.math.BigDecimal;

public interface TaxBuilders {

    interface IdTax {
        RefTax idTax();
    }

    interface RefTax {
        Price refTax(String refTax);
    }

    interface Price {
        Optatives price(BigDecimal price);
    }

    interface Optatives {
        Optatives description(String description);

        Optatives paid(Boolean paid);

        TaxEntity build();
    }
}
