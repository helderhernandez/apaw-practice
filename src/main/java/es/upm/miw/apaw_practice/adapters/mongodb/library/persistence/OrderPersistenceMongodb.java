package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.OrderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.OrderEntity;
import es.upm.miw.apaw_practice.domain.models.library.Order;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.OrderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("orderPersistence")
public class OrderPersistenceMongodb implements OrderPersistence {

    private OrderRepository orderRepository;

    @Autowired
    public OrderPersistenceMongodb(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    public Stream<Order> readAll(){
        return this.orderRepository.findAll().stream()
                .map(OrderEntity::toOrder);

    }
}
