package es.upm.miw.apaw_practice.adapters.mongodb.school.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
public class CourseEntity {
    @DBRef
    private List<StudentEntity> studentEntities;
    @DBRef
    private List<SubjectEntity> subjectEntities;
    @Id
    private String id;
    private Integer academicYear;
    private String group;
    private String academicLevel;
    private LocalDate startDate;
    private LocalDate finishDate;

    public CourseEntity() {
        //empty for framework
    }

    public CourseEntity(List<StudentEntity> studentEntities, List<SubjectEntity> subjectEntities, Integer academicYear, String group, String academicLevel, LocalDate startDate, LocalDate finishDate) {
        this.studentEntities = studentEntities;
        this.subjectEntities = subjectEntities;
        this.academicYear = academicYear;
        this.group = group;
        this.academicLevel = academicLevel;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    public List<SubjectEntity> getSubjectEntities() {
        return subjectEntities;
    }

    public void setSubjectEntities(List<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "studentEntities=" + studentEntities +
                ", subjectEntities=" + subjectEntities +
                ", id='" + id + '\'' +
                ", academicYear=" + academicYear +
                ", group='" + group + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
