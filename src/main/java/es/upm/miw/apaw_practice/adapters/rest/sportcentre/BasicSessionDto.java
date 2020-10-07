package es.upm.miw.apaw_practice.adapters.rest.sportcentre;



import es.upm.miw.apaw_practice.domain.models.sportcentre.Session;

import java.time.LocalDateTime;

public class BasicSessionDto {

    private Integer roomNumber;
    private LocalDateTime date;

    public BasicSessionDto(){
        //Empty from framework
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BasicSessionDto{" +
                "roomNumber=" + roomNumber +
                ", date=" + date +
                '}';
    }
}
