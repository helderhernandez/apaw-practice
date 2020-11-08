package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.OrderEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite.TreeOrders;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite.TreeOrdersComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.orders_composite.TreeOrdersLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CompositeOrdersEntityRepositoryIT {
    private TreeOrders root;
    private TreeOrders leaf;

    @BeforeEach
    void ini(){
        TreeOrders overTwentyEuros;
        TreeOrders lastYears;
        OrderEntity order1=new OrderEntity("1", new BigDecimal(12.3), LocalDateTime.of(2020,10,4,15,25),LocalDateTime.of(2020,10,6,15,37),LocalDateTime.of(2020,10,7,15,37));
        OrderEntity order2=new OrderEntity("2", BigDecimal.ZERO, LocalDateTime.of(2020,3,2,17,37),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37));
        OrderEntity order3=new OrderEntity("3", BigDecimal.ONE, LocalDateTime.of(2020,2,3,8,35),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37));
        OrderEntity order4=new OrderEntity("4", BigDecimal.TEN, LocalDateTime.of(2020,2,6,19,37),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37));

        this.root=new TreeOrdersComposite("Orders");
        this.leaf=new TreeOrdersLeaf(order1);
        this.root.add(this.leaf);
        overTwentyEuros=new TreeOrdersComposite("over twenty euros");

        this.root.add(overTwentyEuros);
        this.root.add(new TreeOrdersLeaf(order2));
        this.root.add(new TreeOrdersLeaf(order4));

        overTwentyEuros.add(new TreeOrdersLeaf(order2));
        overTwentyEuros.add(new TreeOrdersLeaf(order4));

        lastYears=new TreeOrdersComposite("Last Year");
        this.root.add(lastYears);
        lastYears.add(new TreeOrdersLeaf(order3));

    }

    @Test
    void  testIdOfTreeOrdersIfLeaf(){
        assertEquals("1",this.leaf.getId());
    }

    @Test
    void  testIdOfTreeOrdersIfComposite(){
        assertEquals("Orders",this.root.getId());
    }

   @Test
   void testIsComposite(){
        assertTrue(this.root.isComposite());
        assertFalse(this.leaf.isComposite());
   }

}
