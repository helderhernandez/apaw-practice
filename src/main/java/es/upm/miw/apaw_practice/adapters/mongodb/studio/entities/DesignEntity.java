package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities;

import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

@Document
public class DesignEntity {
    @Id
    private String id;
    private String type;
    private Boolean isFinished;
    private BigDecimal cost;
    private String style;
    private List<TattoistEntity> tattoistEntities;

    public DesignEntity() {
        // Empty for framework
    }

    public DesignEntity(String type, Boolean isFinished, BigDecimal cost, String style, List<TattoistEntity> tattoistEntities) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.isFinished = isFinished;
        this.cost = cost;
        this.style = style;
        this.tattoistEntities = tattoistEntities;
    }

    public DesignEntity(DesignCreation designCreation) {
        BeanUtils.copyProperties(designCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public List<TattoistEntity> getTattoistEntities() {
        return tattoistEntities;
    }

    public void setTattoistEntities(List<TattoistEntity> tattoistEntities) {
        this.tattoistEntities = tattoistEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesignEntity)) return false;
        DesignEntity that = (DesignEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "DesignEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", isFinished=" + isFinished +
                ", cost=" + cost +
                ", style='" + style + '\'' +
                ", tattoistEntities=" + tattoistEntities +
                '}';
    }

    public Design toDesign() {
        Design design = new Design();
        BeanUtils.copyProperties(this, design);
        return design;
    }
}






