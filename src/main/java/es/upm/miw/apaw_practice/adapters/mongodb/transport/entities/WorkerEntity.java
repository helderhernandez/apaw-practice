package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class WorkerEntity {
    @Id
    private String id;
    private String name;
    private LocalDate creation;
    private String telephone;
    @Indexed(unique = true)
    private String dni;
    private List<ExtraEntity> extraEntities;

    public WorkerEntity() {
        //empty for framework
    }

    public WorkerEntity(String name, String telephone, String dni, List<ExtraEntity> extraEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.creation = LocalDate.now();
        this.telephone = telephone;
        this.dni = dni;
        this.extraEntities = extraEntities;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<ExtraEntity> getExtraEntities() {
        return extraEntities;
    }

    public void setExtraEntities(List<ExtraEntity> extraEntities) {
        this.extraEntities = extraEntities;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((WorkerEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "WorkerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creation=" + creation +
                ", telephone='" + telephone + '\'' +
                ", dni='" + dni + '\'' +
                ", extraEntities=" + extraEntities +
                '}';
    }
}
