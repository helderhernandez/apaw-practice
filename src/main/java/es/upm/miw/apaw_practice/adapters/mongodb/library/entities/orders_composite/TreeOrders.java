package es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite;

import java.util.List;

public interface TreeOrders {

    boolean isComposite();

    String getId();

    void add(TreeOrders treeOrders);

    void remove(TreeOrders treeOrders);

    List<String> getOrdersId();
}
