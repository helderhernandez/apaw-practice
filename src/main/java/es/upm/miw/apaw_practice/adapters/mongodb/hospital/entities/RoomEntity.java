package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class RoomEntity {

    @Id
    private String id;
    private String area;
    private Integer floor;
    private List<PatientEntity> patientEntities;

    public RoomEntity(){
        //empty for framework
    }

    public RoomEntity(String area, Integer floor, List<PatientEntity> patientEntities) {
        this.id = UUID.randomUUID().toString();
        this.area = area;
        this.floor = floor;
        this.patientEntities = patientEntities;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<PatientEntity> getPatientEntities() {
        return patientEntities;
    }

    public void setPatientEntitys(List<PatientEntity> patientEntitys) {
        this.patientEntities = patientEntitys;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() &&
                (id.equals(((RoomEntity) obj).id));
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id='" + id + '\'' +
                ", area='" + area + '\'' +
                ", floor=" + floor +
                ", patientEntitys=" + patientEntities +
                '}';
    }
}
