package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class DegreeEntity {

    @Id
    private String id;
    @DBRef
    private EmployeeEntity employeeEntity;
    @Indexed(unique = true)
    private String title;
    private String recordNumber;
    private String institute;

    public DegreeEntity() {
        //empty for framework
    }

    public DegreeEntity(EmployeeEntity employeeEntity, String title, String recordNumber, String institute) {
        this.employeeEntity = employeeEntity;
        this.title = title;
        this.recordNumber = recordNumber;
        this.institute = institute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (recordNumber.equals(((DegreeEntity) obj).recordNumber));
    }

    @Override
    public int hashCode() {
        return recordNumber.hashCode();
    }

    @Override
    public String toString() {
        return "DegreeEntity{" +
                "id='" + id + '\'' +
                ", employeeEntity=" + employeeEntity +
                ", title='" + title + '\'' +
                ", recordNumber='" + recordNumber + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }
}
