package es.upm.miw.apaw_practice.domain.models.race;

public class Section {
    private Integer order;
    private Integer lengthInMeters;

    public Section() {
        // empty for framework
    }

    public Section(Integer order, Integer lengthInMeters) {
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
        return "Section{" +
                "order=" + order +
                ", lengthInMeters=" + lengthInMeters +
                '}';
    }
}
