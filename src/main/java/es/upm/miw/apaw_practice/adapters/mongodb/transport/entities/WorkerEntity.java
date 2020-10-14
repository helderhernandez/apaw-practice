package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

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

    public static WorkerBuilder.Name builder() {
        return new Builder();
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

    public Worker toWorker() {
        return new Worker(name, telephone, dni, extraEntities);
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

    public static class Builder implements WorkerBuilder.Name, WorkerBuilder.Telephone, WorkerBuilder.Dni, WorkerBuilder.Optionals {

        private final WorkerEntity workerEntity;

        public Builder() {
            this.workerEntity = new WorkerEntity();
        }

        @Override
        public WorkerBuilder.Telephone name(String name) {
            this.workerEntity.name = name;
            return this;
        }

        @Override
        public WorkerBuilder.Dni telephone(String telephone) {
            this.workerEntity.telephone = telephone;
            return this;
        }

        @Override
        public WorkerBuilder.Optionals dni(String dni) {
            this.workerEntity.dni = dni;
            return this;
        }

        @Override
        public WorkerBuilder.Optionals extraEntities(List<ExtraEntity> extraEntities) {
            this.workerEntity.extraEntities = extraEntities;
            return this;
        }

        @Override
        public WorkerEntity build() {
            return this.workerEntity;
        }
    }
}
