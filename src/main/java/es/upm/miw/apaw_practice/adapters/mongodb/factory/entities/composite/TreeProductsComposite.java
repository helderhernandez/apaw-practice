package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeProductsComposite implements TreeProducts{

    private String productsItemReference;

    private List<TreeProducts> treeProductsList;

    public TreeProductsComposite(String productsItemReference) {
        this.productsItemReference = productsItemReference;
        this.treeProductsList = new ArrayList<>();
    }

    @Override
    public String getItemReference() {
        return this.productsItemReference;
    }

    @Override
    public List<String> getProductsItemReference() {
        return this.treeProductsList.stream()
                .filter(treeProducts -> !treeProducts.isComposite())
                .map(TreeProducts::getItemReference)
                .collect(Collectors.toList());
    }

    @Override
    public void add(TreeProducts treeProducts) {
        this.treeProductsList.add(treeProducts);
    }

    @Override
    public void remove(TreeProducts treeProducts) {
        this.treeProductsList.remove(treeProducts);
    }

    @Override
    public boolean isComposite() {
        return true;
    }
}
