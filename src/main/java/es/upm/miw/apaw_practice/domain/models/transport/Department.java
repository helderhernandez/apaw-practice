package es.upm.miw.apaw_practice.domain.models.transport;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;

import java.util.List;
import java.util.UUID;

public class Department {

    private String id;
    private String name;
    private String ubication;
    private List<WorkerEntity> workerEntityList;

    public Department() {
        //empty for framework
    }

    public Department(String name, String ubication, List<WorkerEntity> workerEntities) {
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

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ubication='" + ubication + '\'' +
                ", workerEntityList=" + workerEntityList +
                '}';
    }
}
