package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite;

public interface TreeRestaurant {

    String getName();

    void add(TreeRestaurant treeRestaurant);

    void remove(TreeRestaurant treeRestaurant);

    boolean isComposite();
}
