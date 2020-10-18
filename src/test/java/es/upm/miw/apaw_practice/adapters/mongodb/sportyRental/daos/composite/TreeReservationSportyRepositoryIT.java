package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos.composite;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos.ReservationSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.ReservationSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.composite.TreeReservationsSporty;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.composite.TreeReservationsSportyComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.composite.TreeReservationsSportyLeaf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class TreeReservationSportyRepositoryIT {

    @Autowired
    private ReservationSportyRepository reservationSportyRepository;

    @Test
    void testTreeReservationSportyLeaf() {
        assertTrue(reservationSportyRepository.findByRefReservation("R3458902").isPresent());
        ReservationSportyEntity reservationSportyEntity = reservationSportyRepository.findByRefReservation("R3458902").get();
        TreeReservationsSporty treeReservationsSportyLeafOne = new TreeReservationsSportyLeaf(reservationSportyEntity);
        assertEquals(LocalDateTime.of(2020, 11, 11, 0, 0), treeReservationsSportyLeafOne.getDateReservation());
        assertEquals("R3458902", treeReservationsSportyLeafOne.getRefReservation());
        assertEquals(new BigDecimal(20), treeReservationsSportyLeafOne.getAmount());
        assertEquals(Boolean.FALSE, treeReservationsSportyLeafOne.isPaidOut());
        assertEquals("Paddle", treeReservationsSportyLeafOne.getCategorySportyEntity().getDescription());
        assertEquals(2, treeReservationsSportyLeafOne.getCustomerSportyEntities().size());
        assertEquals(1, treeReservationsSportyLeafOne.getDiscountSportyEntities().size());

    }

    @Test
    void testTreeReservationSportyComposite() {
        assertFalse(reservationSportyRepository.findAll().isEmpty());
        List<ReservationSportyEntity> listReservationSportyEntity = reservationSportyRepository.findAll();
        TreeReservationsSporty treeReservationsSportyCompositeOne = new TreeReservationsSportyComposite("Association One");
        treeReservationsSportyCompositeOne.add(new TreeReservationsSportyLeaf(listReservationSportyEntity.get(0)));
        TreeReservationsSporty treeReservationsSportyLeafOneRemove=new TreeReservationsSportyLeaf(listReservationSportyEntity.get(3));
        treeReservationsSportyCompositeOne.add(treeReservationsSportyLeafOneRemove);
        assertEquals("Association One", treeReservationsSportyCompositeOne.getNameAssociationOfReservations());
        assertEquals(2, treeReservationsSportyCompositeOne.getNumberTreeReservationsSporty());
        assertEquals("R3458901,R3458904", String.join(",", treeReservationsSportyCompositeOne.getListNameAssociationOfReservations()));
        treeReservationsSportyCompositeOne.remove(treeReservationsSportyLeafOneRemove);
        assertEquals(1, treeReservationsSportyCompositeOne.getNumberTreeReservationsSporty());
        assertEquals("R3458901", String.join("", treeReservationsSportyCompositeOne.getListNameAssociationOfReservations()));
        TreeReservationsSporty treeReservationsSportyCompositeTwo = new TreeReservationsSportyComposite("Association Two");
        treeReservationsSportyCompositeTwo.add(new TreeReservationsSportyLeaf(listReservationSportyEntity.get(1)));
        TreeReservationsSporty treeReservationsSportyLeafTwoRemove=new TreeReservationsSportyLeaf(listReservationSportyEntity.get(2));
        treeReservationsSportyCompositeTwo.add(treeReservationsSportyLeafTwoRemove);
        assertEquals("Association Two", treeReservationsSportyCompositeTwo.getNameAssociationOfReservations());
        assertEquals(2, treeReservationsSportyCompositeTwo.getNumberTreeReservationsSporty());
        assertEquals("R3458902,R3458903", String.join(",", treeReservationsSportyCompositeTwo.getListNameAssociationOfReservations()));
        treeReservationsSportyCompositeTwo.remove(treeReservationsSportyLeafTwoRemove);
        assertEquals(1, treeReservationsSportyCompositeTwo.getNumberTreeReservationsSporty());
        assertEquals("R3458902", String.join("", treeReservationsSportyCompositeTwo.getListNameAssociationOfReservations()));
    }

}
