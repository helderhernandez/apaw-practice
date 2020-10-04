package es.upm.miw.apaw_practice.domain.models.school;

import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.TeacherEntity;

import java.time.LocalDateTime;

public class Subject {
    private String id;
    private TeacherEntity teacherEntity;
    private String name;
    private LocalDateTime creationDate;
    private String knowledgeArea;

    public Subject() {
        //empty for framework
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
