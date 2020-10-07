package es.upm.miw.apaw_practice.domain.models.sportcentre;


import es.upm.miw.apaw_practice.adapters.rest.sportcentre.BasicSessionDto;

import java.time.LocalDateTime;
import java.util.List;

public class Session {

    private String id;
    private Integer roomNumber;
    private LocalDateTime date;
    private List<Assistant> assistants;
    private Instructor instructor;

    public Session(){
        //Empty from framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Assistant> assistants) {
        this.assistants = assistants;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", roomNumber=" + roomNumber +
                ", date=" + date +
                ", assistants=" + assistants +
                ", instructor=" + instructor +
                '}';
    }

    public BasicSessionDto toBasicSessionDto() {
        BasicSessionDto basicSession = new BasicSessionDto();
        basicSession.setRoomNumber(this.getRoomNumber());
        basicSession.setDate(this.getDate());
        return basicSession;
    }
}
