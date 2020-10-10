package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;

import java.util.List;

public class TreeProductsLeaf implements TreeProducts{

    private ProductEntity productEntity;

    public TreeProductsLeaf(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String getItemReference() {
        return this.productEntity.getItemReference();
    }

    @Override
    public List<String> getProductsItemReference() {
        return List.of(productEntity.getItemReference());
    }

    @Override
    public void add(TreeProducts treeProducts) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeProducts treeProducts) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return false;
    }
}
