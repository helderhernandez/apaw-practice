package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite;

import java.util.List;

public class TreeRestaurantComposite implements TreeRestaurant {
    List<TreeRestaurant> treeRestaurantList;

    public TreeRestaurantComposite() {
        ////////////////////////////
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void add(TreeRestaurant treeRestaurant) {
        this.treeRestaurantList.add(treeRestaurant);
    }

    @Override
    public void remove(TreeRestaurant treeRestaurant) {
        this.treeRestaurantList.remove(treeRestaurant);
    }

    @Override
    public boolean isComposite() { return true; }
}
