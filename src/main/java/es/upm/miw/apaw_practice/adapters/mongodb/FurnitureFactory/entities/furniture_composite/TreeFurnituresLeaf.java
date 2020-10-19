package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;

import java.util.List;


public class TreeFurnituresLeaf implements TreeFurnitures {

    private FurnitureEntity furnitureEntity;

    public TreeFurnituresLeaf(FurnitureEntity furnitureEntity) {
        this.furnitureEntity = furnitureEntity;
    }

    @Override
    public boolean isComposite() {
        return false;
    }
    @Override
    public String getName() {
        return this.furnitureEntity.getName();
    }

    @Override
    public void add(TreeFurnitures treeFilmDirectors) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeFurnitures treeFilmDirectors) {
        //Do nothing is leaf
    }
    @Override
    public List<String> getFurnituresName() {
        return List.of(this.furnitureEntity.getName());
    }

}
