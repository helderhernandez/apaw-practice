package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.transport.Department;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class DepartmentEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String ubication;
    private List<WorkerEntity> workerEntityList;

    public DepartmentEntity() {
        //empty for framework
    }

    public DepartmentEntity(String name, String ubication, List<WorkerEntity> workerEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ubication = ubication;
        this.workerEntityList = workerEntities;
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

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public List<WorkerEntity> getWorkerEntityList() {
        return workerEntityList;
    }

    public void setWorkerEntityList(List<WorkerEntity> workerEntityList) {
        this.workerEntityList = workerEntityList;
    }

    public void fromDepartment(Department department) {
        BeanUtils.copyProperties(department, this);
    }

    public Department toDepartment() {
        Department department = new Department();
        BeanUtils.copyProperties(this, department);
        return department;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((DepartmentEntity) obj).id));
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ubication='" + ubication + '\'' +
                ", workerEntityList=" + workerEntityList +
                '}';
    }
}
