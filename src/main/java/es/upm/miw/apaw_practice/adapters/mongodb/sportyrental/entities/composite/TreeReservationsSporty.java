package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TreeReservationsSporty {

    String getIdReservation();

    LocalDateTime getDateReservation();

    String getRefReservation();

    BigDecimal getAmount();

    List<CustomerSportyEntity> getCustomerSportyEntities();

    List<DiscountSportyEntity> getDiscountSportyEntities();

    CategorySportyEntity getCategorySportyEntity();

    boolean isPaidOut();

    boolean isComposite();

    void add(TreeReservationsSporty treeReservationsSporty);

    void remove(TreeReservationsSporty treeReservationsSporty);

    Integer getNumberTreeReservationsSporty();

    String getNameAssociationOfReservations();

    List<String> getListNameAssociationOfReservations();
}
