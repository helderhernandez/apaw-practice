package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.RestaurantEntity;

import java.util.List;

public class TreeRestaurantLeaf implements TreeRestaurant {
    private RestaurantEntity restaurantEntity;

    public TreeRestaurantLeaf(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }

    @Override
    public String getName() {
        return this.restaurantEntity.getName();
    }

    @Override
    public void add(TreeRestaurant treeRestaurant) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeRestaurant treeRestaurant) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public List<String> getListName() {
        return List.of(restaurantEntity.getName());
    }
}
