package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.springframework.beans.BeanUtils;
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

    public static Builder builder(TeacherEntity teacherEntity, String name) {
        return new Builder(teacherEntity, name);
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

    public Subject toSubject() {
        Subject subject = new Subject();
        BeanUtils.copyProperties(this, subject);
        return subject;
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

    public static class Builder {

        private final SubjectEntity subject;

        private Builder(TeacherEntity teacherEntity, String name) {
            this.subject = new SubjectEntity();
            this.subject.teacherEntity = teacherEntity;
            this.subject.name = name;
            this.subject.creationDate = LocalDateTime.now();
        }

        public Builder knowledgeArea(String knowledgeArea) {
            this.subject.knowledgeArea = knowledgeArea;
            return this;
        }

        public SubjectEntity build() {
            return this.subject;
        }
    }
}
