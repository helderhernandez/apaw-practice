package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.Order;
import es.upm.miw.apaw_practice.domain.services.library.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(OrderResource.ORDER)
public class OrderResource {
    static final String ORDER = "/library/order";

    private OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Stream<Order> readAll(){
        return this.orderService.readAll();
    }

}

