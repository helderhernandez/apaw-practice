package es.upm.miw.apaw_practice.domain.models.transport;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Worker {
    private String id;
    private String name;
    private LocalDate creation;
    private String telephone;
    private String dni;
    private List<ExtraEntity> extraEntities;

    public Worker() {
        //empty for framework
    }

    public Worker(String name, String telephone, String dni, List<ExtraEntity> extraEntities) {
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

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
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
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creation=" + creation +
                ", telephone='" + telephone + '\'' +
                ", dni='" + dni + '\'' +
                ", extraEntities=" + extraEntities +
                '}';
    }
}
