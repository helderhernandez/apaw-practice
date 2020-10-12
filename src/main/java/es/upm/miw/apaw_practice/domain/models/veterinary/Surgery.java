package es.upm.miw.apaw_practice.domain.models.veterinary;

import java.math.BigDecimal;
import java.util.List;

public class Surgery {

    private String id;
    private String type;
    private BigDecimal price;
    private List<Animal> animals;
    private List<Veterinary> veterinaries;

    public Surgery() {
        //Empty for framework
    }
}
