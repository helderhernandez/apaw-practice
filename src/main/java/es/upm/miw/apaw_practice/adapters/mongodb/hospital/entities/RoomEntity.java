package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class RoomEntity {

    @Id
    private String id;
    private String area;
    private int floor;
    private List<PatientEntity> patientEntitys;

    public RoomEntity(){
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<PatientEntity> getPatientEntitys() {
        return patientEntitys;
    }

    public void setPatientEntitys(List<PatientEntity> patientEntitys) {
        this.patientEntitys = patientEntitys;
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
                ", patientEntitys=" + patientEntitys +
                '}';
    }
}
