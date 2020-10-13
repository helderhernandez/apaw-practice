package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite;

public interface TreeCars {

    String enrollment();

    boolean isComposite();

    void add(TreeCars treeCars);

    void remove(TreeCars treeCars);
}
