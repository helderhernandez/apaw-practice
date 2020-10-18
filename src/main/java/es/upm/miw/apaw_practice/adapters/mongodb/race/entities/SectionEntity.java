package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import es.upm.miw.apaw_practice.domain.models.race.Section;

public class SectionEntity {
    private Integer order;
    private Integer lengthInMeters;

    public SectionEntity() {
        // empty for framework
    }

    public SectionEntity(Integer order, Integer lengthInMeters) {
        this.order = order;
        this.lengthInMeters = lengthInMeters;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getLengthInMeters() {
        return lengthInMeters;
    }

    public void setLengthInMeters(Integer lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    @Override
    public String toString() {
        return "SectionEntity{" +
                "order=" + order +
                ", lengthInMeters=" + lengthInMeters +
                '}';
    }

    public Section toSection() {
        return new Section(this.order, this.lengthInMeters);
    }
}
