package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeRacketsComposite implements TreeRackets {

    private String name;
    private List<TreeRackets> treeRacketsList;

    public TreeRacketsComposite(String name) {
        this.name = name;
        this.treeRacketsList = new ArrayList<>();
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String brand() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public BigDecimal price() {
        return null;
    }

    @Override
    public String weight() {
        return null;
    }

    @Override
    public PlayerEntity playerEntity() {
        return null;
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeRackets treeRackets) {
        treeRacketsList.add(treeRackets);
    }

    @Override
    public void remove(TreeRackets treeRackets) {
        treeRacketsList.remove(treeRackets);
    }

    @Override
    public List<String> getRacketsName() {
        return this.treeRacketsList.stream()
                .filter(treeRackets -> !treeRackets.isComposite())
                .map(TreeRackets::name)
                .collect(Collectors.toList());
    }
}
