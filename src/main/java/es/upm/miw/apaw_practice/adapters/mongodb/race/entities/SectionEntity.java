package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

public class SectionEntity {
    private Integer ordinalNumber;
    private Integer lengthInMeters;

    public SectionEntity() {
        // empty for framework
    }

    public SectionEntity(Integer ordinalNumber, Integer lengthInMeters) {
        this.ordinalNumber = ordinalNumber;
        this.lengthInMeters = lengthInMeters;
    }

    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
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
                "ordinalNumber=" + ordinalNumber +
                ", lengthInMeters=" + lengthInMeters +
                '}';
    }
}
