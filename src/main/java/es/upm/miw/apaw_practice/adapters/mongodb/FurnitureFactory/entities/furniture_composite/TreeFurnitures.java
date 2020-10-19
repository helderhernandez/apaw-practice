package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite;


import java.util.List;

public interface TreeFurnitures {

    boolean isComposite();

    String getName();

    void add(TreeFurnitures treeFilmDirectors);

    void remove(TreeFurnitures treeFilmDirectors);
    List<String> getFurnituresName();
}
