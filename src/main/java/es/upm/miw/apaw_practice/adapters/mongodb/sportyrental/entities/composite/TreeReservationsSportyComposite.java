package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeReservationsSportyComposite implements TreeReservationsSporty {

    private List<TreeReservationsSporty> listTreeReservationsSporty;

    private String nameAssociationOfReservations;

    public TreeReservationsSportyComposite(String nameAssociationOfReservations) {
        this.listTreeReservationsSporty = new ArrayList<>();
        this.nameAssociationOfReservations = nameAssociationOfReservations;
    }

    @Override
    public String getIdReservation() {
        return null;
    }

    @Override
    public LocalDateTime getDateReservation() {
        return null;
    }

    @Override
    public String getRefReservation() {
        return null;
    }

    @Override
    public BigDecimal getAmount() {
        return null;
    }

    @Override
    public List<CustomerSportyEntity> getCustomerSportyEntities() {
        return List.of();
    }

    @Override
    public List<DiscountSportyEntity> getDiscountSportyEntities() {
        return List.of();
    }

    @Override
    public CategorySportyEntity getCategorySportyEntity() {
        return null;
    }

    @Override
    public boolean isPaidOut() {
        return false;
    }

    @Override
    public boolean isComposite() {
        return Boolean.TRUE;
    }

    @Override
    public void add(TreeReservationsSporty treeReservationsSporty) {
        this.listTreeReservationsSporty.add(treeReservationsSporty);
    }

    @Override
    public void remove(TreeReservationsSporty treeReservationsSporty) {
        this.listTreeReservationsSporty.remove(treeReservationsSporty);
    }

    @Override
    public Integer getNumberTreeReservationsSporty() {
        return this.listTreeReservationsSporty.size();
    }

    @Override
    public String getNameAssociationOfReservations() {
        return this.nameAssociationOfReservations;
    }

    @Override
    public List<String> getListNameAssociationOfReservations() {
        return listTreeReservationsSporty.stream()
                .filter(TreeReservationsSporty -> !TreeReservationsSporty.isComposite())
                .map(TreeReservationsSporty::getRefReservation)
                .collect(Collectors.toList());
    }

}
