package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeRestaurantComposite implements TreeRestaurant {
    private List<TreeRestaurant> treeRestaurantList;
    private String name;

    public TreeRestaurantComposite(String name) {
        this.treeRestaurantList = new ArrayList<TreeRestaurant>();
        this.name = name;
    }

    @Override
    public String getName() { return this.name; }

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

    @Override
    public List<String> getListName() {
        return this.treeRestaurantList.stream()
                .filter(treeRestaurant -> !treeRestaurant.isComposite())
                .map(TreeRestaurant::getName)
                .collect(Collectors.toList());
    }
}
