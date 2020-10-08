package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import java.math.BigDecimal;
import java.util.List;

public interface TreeRackets {
    String id();

    String name();

    String brand();

    String description();

    BigDecimal price();

    String weight();

    PlayerEntity playerEntity();

    Boolean isComposite();

    void add(TreeRackets treeRackets);

    void remove(TreeRackets treeRackets);

    List<String> getRacketsName();
}
