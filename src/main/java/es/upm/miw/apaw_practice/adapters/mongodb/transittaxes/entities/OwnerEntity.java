package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Owner;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class OwnerEntity {

    @Id
    private String id;
    private String name;
    private String familyName;
    @Indexed(unique = true)
    private String dni;

    public OwnerEntity() {
        //empty from framework
    }

    public OwnerEntity(Owner owner) {
        BeanUtils.copyProperties(owner, this);
        this.id = UUID.randomUUID().toString();
    }

    public static OwnerBuilders.Id builder() {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Owner toOwner() {
        Owner owner = new Owner();
        BeanUtils.copyProperties(this, owner);
        return owner;

    }

    public static class Builder implements OwnerBuilders.Dni, OwnerBuilders.Id, OwnerBuilders.Optatives {

        private OwnerEntity ownerEntity;

        public Builder() {
            this.ownerEntity = new OwnerEntity();
        }

        @Override
        public OwnerBuilders.Dni idOwner(String id) {
            this.ownerEntity.id = id;
            return this;
        }

        @Override
        public OwnerBuilders.Optatives dni(String dni) {
            this.ownerEntity.dni = dni;
            return this;
        }

        @Override
        public OwnerBuilders.Optatives name(String name) {
            this.ownerEntity.name = name;
            return this;
        }

        @Override
        public OwnerBuilders.Optatives familyName(String familyName) {
            this.ownerEntity.familyName = familyName;
            return this;
        }

        @Override
        public OwnerEntity build() {
            return this.ownerEntity;
        }
    }
}
