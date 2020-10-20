package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CDOwnerEntity;

public class TreeCDOwnerLeaf implements TreeCDOwner {
    private CDOwnerEntity ownerEntity;

    public TreeCDOwnerLeaf(CDOwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    public CDOwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(CDOwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    @Override
    public void add(TreeCDOwner treeCDOwner) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeCDOwner treeCDOwner) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public int numberOfDescendants() {
        return 1;
    }
}
