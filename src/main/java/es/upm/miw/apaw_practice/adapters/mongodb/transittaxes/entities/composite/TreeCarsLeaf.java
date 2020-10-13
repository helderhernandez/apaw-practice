package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;

import java.util.List;

public class TreeCarsLeaf implements TreeCars {

    private CarEntity carEntity;

    public TreeCarsLeaf(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    @Override
    public String enrollment() {
        return carEntity.getEnrollment();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeCars treeArticles) {
        // Do nothing because is leaf

    }

    @Override
    public void remove(TreeCars treeArticles) {
        // Do nothing because is leaf

    }
}
