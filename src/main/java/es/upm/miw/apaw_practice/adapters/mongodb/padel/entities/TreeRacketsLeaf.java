package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import java.math.BigDecimal;
import java.util.List;

public class TreeRacketsLeaf implements TreeRackets {

    private RacketEntity racketEntity;

    public TreeRacketsLeaf(RacketEntity racketEntity) {
        this.racketEntity = racketEntity;
    }

    @Override
    public String id() {
        return this.racketEntity.getId();
    }

    @Override
    public String name() {
        return this.racketEntity.getName();
    }

    @Override
    public String brand() {
        return this.racketEntity.getBrand();
    }

    @Override
    public String description() {
        return this.racketEntity.getDescription();
    }

    @Override
    public BigDecimal price() {
        return this.racketEntity.getPrice();
    }

    @Override
    public String weight() {
        return this.racketEntity.getWeight();
    }

    @Override
    public PlayerEntity playerEntity() {
        return this.racketEntity.getPlayerEntity();
    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeRackets treeRackets) {
        //Do nothing because this class is a leaf
    }

    @Override
    public void remove(TreeRackets treeRackets) {
        //Do nothing because this class is a leaf
    }

    @Override
    public List<String> getRacketsName() {
        return null;
    }

}
