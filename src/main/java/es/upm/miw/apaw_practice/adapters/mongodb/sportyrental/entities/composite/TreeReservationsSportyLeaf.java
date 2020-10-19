package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.ReservationSportyEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TreeReservationsSportyLeaf implements TreeReservationsSporty {

    private ReservationSportyEntity reservationSportyEntity;

    public TreeReservationsSportyLeaf(ReservationSportyEntity reservationSportyEntity) {
        this.reservationSportyEntity = reservationSportyEntity;
    }

    @Override
    public String getIdReservation() {
        return this.reservationSportyEntity.getIdReservation();
    }

    @Override
    public LocalDateTime getDateReservation() {
        return this.reservationSportyEntity.getDateReservation();
    }

    @Override
    public String getRefReservation() {
        return this.reservationSportyEntity.getRefReservation();
    }

    @Override
    public BigDecimal getAmount() {
        return this.reservationSportyEntity.getAmount();
    }

    @Override
    public List<CustomerSportyEntity> getCustomerSportyEntities() {
        return this.reservationSportyEntity.getCustomerSportyEntities();
    }

    @Override
    public List<DiscountSportyEntity> getDiscountSportyEntities() {
        return this.reservationSportyEntity.getDiscountSportyEntity();
    }

    @Override
    public CategorySportyEntity getCategorySportyEntity() {
        return this.reservationSportyEntity.getCategorySportyEntity();
    }

    @Override
    public boolean isPaidOut() {
        return this.reservationSportyEntity.getPaidOut();
    }

    @Override
    public boolean isComposite() {
        return Boolean.FALSE;
    }

    @Override
    public void add(TreeReservationsSporty treeReservationsSporty) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeReservationsSporty treeReservationsSporty) {
        //Do nothing is leaf
    }

    @Override
    public Integer getNumberTreeReservationsSporty() {
        return null;
    }

    @Override
    public String getNameAssociationOfReservations() {
        return null;
    }

    @Override
    public List<String> getListNameAssociationOfReservations() {
        return List.of();
    }
}
