package es.upm.miw.apaw_practice.domain.models.museum;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

public class Patron implements PatronComponent {

    private String id;
    private Paint paint;
    private String name;
    private String surname;
    private BigDecimal contribution;

    public Patron(String id, Paint paint, String name, String surname, BigDecimal contribution) {
        this.id = id;
        this.paint = paint;
        this.name = name;
        this.surname = surname;
        this.contribution = contribution;
    }

    //#region Override methods

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(PatronComponent patronComponent) {
    }

    @Override
    public void remove(PatronComponent patronComponent) {

    }

    @Override
    public List<PatronComponent> getPatronComponentList() {
        return null;
    }

    //#endregion
    //#region Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
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



}
