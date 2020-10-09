package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class BedEntity {

    @Id
    private String id;
    private Integer width;
    private Integer height;
    private Boolean occupied;
    private LocalDateTime internedDate;
    @DBRef
    private RoomEntity roomEntity;

    public BedEntity(){
        //empty for framework
    }

    public BedEntity(Integer width, Integer height, Boolean occupied, LocalDateTime internedDate, RoomEntity roomEntity) {
        this.id = UUID.randomUUID().toString();
        this.width = width;
        this.height = height;
        this.occupied = occupied;
        this.internedDate = internedDate;
        this.roomEntity = roomEntity;
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

    public Bed toBed() {
        Bed bed = new Bed();
        BeanUtils.copyProperties(this, bed);
        return bed;
    }
}
