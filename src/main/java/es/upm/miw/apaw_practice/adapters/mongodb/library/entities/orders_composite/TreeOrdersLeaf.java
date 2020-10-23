package es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.OrderEntity;

import java.util.List;

public class TreeOrdersLeaf implements TreeOrders{
    private OrderEntity orderEntity;

    public TreeOrdersLeaf(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String getId() {
        return this.orderEntity.getId();
    }

    @Override
    public void add(TreeOrders treeOrders) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeOrders treeOrders) {
        //Do nothing is leaf
    }

    @Override
    public List<String> getOrdersId() {
        return List.of(this.orderEntity.getId());
    }
}
