package es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite;

import java.util.ArrayList;
import java.util.List;

public class TreeOrdersComposite implements TreeOrders{

    private String ordersId;
    private List<TreeOrders> treeOrdersList;

    public TreeOrdersComposite(String ordersId) {
        this.ordersId = ordersId;
        this.treeOrdersList=new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String getId() {
        return this.ordersId;
    }

    @Override
    public void add(TreeOrders treeOrders) {
        treeOrdersList.add(treeOrders);
    }

    @Override
    public void remove(TreeOrders treeOrders) {
        treeOrdersList.remove(treeOrders);
    }

    @Override
    public List<String> getOrdersId() {
        return null;
    }
}
