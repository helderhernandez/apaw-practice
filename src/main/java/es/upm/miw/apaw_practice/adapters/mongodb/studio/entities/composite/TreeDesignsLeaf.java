package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.DesignEntity;

import java.math.BigDecimal;

public class TreeDesignsLeaf implements TreeDesigns {

    private DesignEntity designEntity;

    public TreeDesignsLeaf(DesignEntity designEntity) {
        this.designEntity = designEntity;
    }

    @Override
    public String getType() {
        return designEntity.getType();
    }

    @Override
    public BigDecimal getCost() {
        return designEntity.getCost();
    }

    @Override
    public void add(TreeDesigns treeDesigns) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void remove(TreeDesigns treeDesigns) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public int numberOfDescendants() {
        return 1;
    }
}
