package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
public class SessionEntity {

    @Id
    private String id;
    private Integer roomNumber;
    private LocalDateTime date;
    @DBRef
    private List<AssistantEntity> assistants;
    @DBRef
    private InstructorEntity instructor;

    public SessionEntity(String id, Integer roomNumber, List<AssistantEntity> assistants, InstructorEntity instructor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.assistants = assistants;
        this.instructor = instructor;
        this.date = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomNumber() {
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

    public List<AssistantEntity> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<AssistantEntity> assistants) {
        this.assistants = assistants;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SessionEntity{" +
                "id='" + id + '\'' +
                ", roomNumber=" + roomNumber +
                ", date=" + date +
                ", assistants=" + assistants +
                ", instructor=" + instructor +
                '}';
    }
}
