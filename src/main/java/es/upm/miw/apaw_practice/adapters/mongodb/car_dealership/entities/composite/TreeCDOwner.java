package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite;

public interface TreeCDOwner {
    void add(TreeCDOwner treeCDOwner);

    void remove(TreeCDOwner treeCDOwner);

    boolean isComposite();

    int numberOfDescendants();
}
