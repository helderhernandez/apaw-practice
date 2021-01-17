package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TreeDesignsComposite implements  TreeDesigns{

    private String type;
    private BigDecimal cost;

    private List<TreeDesigns> treeDesignsList;


    public TreeDesignsComposite(String type, BigDecimal cost) {
        this.type = type;
        this.cost = cost;
        this.treeDesignsList = new ArrayList<>();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public void add(TreeDesigns treeDesigns) {
        this.treeDesignsList.add(treeDesigns);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void remove(TreeDesigns treeDesigns) {
        this.treeDesignsList.remove(treeDesigns);
    }

    @Override
    public int numberOfDescendants() {
        return this.treeDesignsList.size();
    }
}

