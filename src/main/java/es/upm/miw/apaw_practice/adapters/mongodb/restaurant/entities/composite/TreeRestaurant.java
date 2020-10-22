package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite;

import java.util.List;

public interface TreeRestaurant {

    String getName();

    void add(TreeRestaurant treeRestaurant);

    void remove(TreeRestaurant treeRestaurant);

    boolean isComposite();

    List<String> getListName();
}
