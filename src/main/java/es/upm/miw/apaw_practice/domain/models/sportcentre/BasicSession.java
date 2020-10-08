package es.upm.miw.apaw_practice.domain.models.sportcentre;

import java.time.LocalDateTime;

public class BasicSession {

    private Integer roomNumber;
    private LocalDateTime date;

    public BasicSession(){
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
        return "BasicSession{" +
                "roomNumber=" + roomNumber +
                ", date=" + date +
                '}';
    }
}
