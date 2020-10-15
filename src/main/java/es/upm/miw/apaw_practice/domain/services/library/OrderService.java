package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Order;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.OrderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OrderService {

    private OrderPersistence orderPersistence;

    @Autowired
    public OrderService(OrderPersistence orderPersistence){
        this.orderPersistence=orderPersistence;
    }

    public Stream<Order> readAll(){
        return this.orderPersistence.readAll();
    }


}
