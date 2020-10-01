package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class BedEntity {

    @Id
    private String id;
    private int width;
    private int height;
    private Boolean occupied;
    private RoomEntity roomEntity;

    public BedEntity(){
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() &&
                (id.equals(((BedEntity) obj).id));
    }

    @Override
    public String toString() {
        return "BedEntity{" +
                "id='" + id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", occupied=" + occupied +
                ", roomEntity=" + roomEntity +
                '}';
    }

}
