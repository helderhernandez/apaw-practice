package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite;

import java.math.BigDecimal;

public interface TreeDesigns {

    String getType();

    BigDecimal getCost();

    void add(TreeDesigns treeDesigns);

    boolean isComposite();

    void remove(TreeDesigns treeDesigns);

    int numberOfDescendants();
}
