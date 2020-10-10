package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite;

import java.util.List;

public interface TreeProducts {

    String getItemReference();

    List<String> getProductsItemReference();

    void add(TreeProducts treeProducts);

    void remove(TreeProducts treeProducts);

    boolean isComposite();

}

