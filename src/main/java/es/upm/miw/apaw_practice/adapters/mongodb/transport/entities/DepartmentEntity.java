package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class DepartmentEntity {
    @Id
    private String id;
    private String name;
    private String ubication;

    public DepartmentEntity() {
        //empty for framework
    }

    public DepartmentEntity(String name, String ubication) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ubication = ubication;
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
                '}';
    }
}
