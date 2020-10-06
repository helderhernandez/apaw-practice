package es.upm.miw.apaw_practice.domain.models.hospital;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.RoomEntity;

import java.time.LocalDateTime;

public class Bed {

    private String id;
    private Integer width;
    private Integer height;
    private Boolean occupied;
    private LocalDateTime internedDate;
    private RoomEntity room;

    public Bed(){
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public LocalDateTime getInternedDate() {
        return internedDate;
    }

    public void setInternedDate(LocalDateTime internedDate) {
        this.internedDate = internedDate;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id='" + id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", occupied=" + occupied +
                ", internedDate=" + internedDate +
                ", roomEntity=" + room +
                '}';
    }
}
