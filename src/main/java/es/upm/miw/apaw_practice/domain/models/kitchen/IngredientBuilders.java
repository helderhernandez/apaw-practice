package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.math.BigDecimal;

public interface IngredientBuilders {
    interface Id {
        Name id(String id);
    }

    interface Name {
        PricePerKg name(String name);
    }

    interface PricePerKg {
        WeightKg pricePerKg(BigDecimal pricePerKg);
    }

    interface WeightKg {
        Optionals weightKg(Double weightKg);
    }

    interface Optionals {
        Optionals washed(Boolean washed);

        Optionals elaborated(Boolean elaborated);

        Ingredient build();
    }
}
