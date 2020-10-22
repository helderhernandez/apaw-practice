package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;

import java.text.NumberFormat;
import java.math.BigDecimal;

public class PatronEntity {
    @Id
    private String id;
    @DBRef
    private PaintEntity paintEntity;
    private String name;
    private String surname;
    private BigDecimal contribution;

    public PatronEntity() {
        //empty from framework
    }

    public PatronEntity(String id, PaintEntity paintEntity, String name, String surname, BigDecimal contribution) {
        this.id = id;
        this.paintEntity = paintEntity;
        this.name = name;
        this.surname = surname;
        this.contribution = contribution;
    }

    //#region Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaintEntity getPaintEntity() {
        return paintEntity;
    }

    public void setPaintEntity(PaintEntity paintEntity) {
        this.paintEntity = paintEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getContribution() {
        return contribution;
    }

    public void setContribution(BigDecimal contribution) {
        this.contribution = contribution;
    }
    //#endregion

    //#region Override methods

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((PatronEntity) obj).id));
    }

    @Override
    public String toString() {
        return String.format(
                "PatronEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "surname=%s, " +
                        "contribution=%s, " +
                        "paintEntity=%s" +
                        "}",
                id,
                name,
                surname,
                NumberFormat.getCurrencyInstance().format(contribution),
                paintEntity
        );
    }
    //#endregion
}
