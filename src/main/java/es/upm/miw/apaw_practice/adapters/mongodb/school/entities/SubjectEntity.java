package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class SubjectEntity {
    @DBRef
    private TeacherEntity teacherEntity;
    @Id
    private String id;
    private String name;
    private LocalDateTime creationDate;
    private String knowledgeArea;

    public SubjectEntity() {
        //empty for framework
    }

    public SubjectEntity(TeacherEntity teacherEntity, String name, String knowledgeArea) {
        this.teacherEntity = teacherEntity;
        this.name = name;
        this.creationDate = LocalDateTime.now();
        this.knowledgeArea = knowledgeArea;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public void setKnowledgeArea(String knowledgeArea) {
        this.knowledgeArea = knowledgeArea;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "teacherEntity=" + teacherEntity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", knowledgeArea='" + knowledgeArea + '\'' +
                '}';
    }
}
