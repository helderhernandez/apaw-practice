package es.upm.miw.apaw_practice.domain.models.hospital;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;

import java.util.List;

public class Room {

    private String id;
    private String area;
    private Integer floor;
    private List<PatientEntity> patientEntities;

    public Room(){
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<PatientEntity> getPatientEntities() {
        return patientEntities;
    }

    public void setPatientEntities(List<PatientEntity> patientEntities) {
        this.patientEntities = patientEntities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", area='" + area + '\'' +
                ", floor=" + floor +
                ", patientEntities=" + patientEntities +
                '}';
    }
}
