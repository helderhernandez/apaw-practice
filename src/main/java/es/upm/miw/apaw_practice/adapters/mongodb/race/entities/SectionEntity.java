package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class SectionEntity {
    @DBRef
    private RaceEntity raceEntity;
    private Integer ordinalNumber;
    private Integer lengthInMeters;

    public SectionEntity() {
        // empty for framework
    }

    public SectionEntity(RaceEntity raceEntity, Integer ordinalNumber, Integer lengthInMeters) {
        this.raceEntity = raceEntity;
        this.ordinalNumber = ordinalNumber;
        this.lengthInMeters = lengthInMeters;
    }

    public RaceEntity getRaceEntity() {
        return raceEntity;
    }

    public void setRaceEntity(RaceEntity raceEntity) {
        this.raceEntity = raceEntity;
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
                "raceEntity=" + raceEntity +
                ", ordinalNumber=" + ordinalNumber +
                ", lengthInMeters=" + lengthInMeters +
                '}';
    }
}
