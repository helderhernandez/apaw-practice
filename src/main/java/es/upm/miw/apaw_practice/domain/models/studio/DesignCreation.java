package es.upm.miw.apaw_practice.domain.models.studio;

import java.math.BigDecimal;

public class DesignCreation {

    private String type;
    private Boolean isFinished;
    private BigDecimal cost;
    private String style;

    public DesignCreation(String type, Boolean isFinished, BigDecimal cost, String style) {
        this.type = type;
        this.isFinished = isFinished;
        this.cost = cost;
        this.style = style;
    }

    public DesignCreation() {
        // Empty for framework
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "DesignCreation{" +
                "type='" + type + '\'' +
                ", isFinished=" + isFinished +
                ", cost=" + cost +
                ", style='" + style + '\'' +
                '}';
    }
}
