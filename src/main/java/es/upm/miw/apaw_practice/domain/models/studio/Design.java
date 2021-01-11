package es.upm.miw.apaw_practice.domain.models.studio;

import java.math.BigDecimal;

public class Design {
    private String id;
    private String type;
    private Boolean isFinished;
    private BigDecimal cost;
    private String style;

    public Design() {
        // Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Design{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", isFinished=" + isFinished +
                ", cost=" + cost +
                ", style='" + style + '\'' +
                '}';
    }
}
