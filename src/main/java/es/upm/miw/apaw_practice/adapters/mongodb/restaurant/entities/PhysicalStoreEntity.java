package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class PhysicalStoreEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String address;
    private Integer size;
    private Boolean terrace;
    private LocalDateTime opening;

    public PhysicalStoreEntity() {
        //empty for framework
    }

    public static PhysicalStoreBuilder.address builder() {
        return new Builder();
    }

    public PhysicalStoreEntity(String id, String address, Integer size, Boolean terrace, LocalDateTime opening) {
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.size = size;
        this.terrace = terrace;
        this.opening = opening;
    }

    public PhysicalStoreEntity(PhysicalStore physicalStore) {
        BeanUtils.copyProperties(physicalStore, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getTerrace() {
        return terrace;
    }

    public void setTerrace(Boolean terrace) {
        this.terrace = terrace;
    }

    public LocalDateTime getOpening() {
        return opening;
    }

    public void setOpening(LocalDateTime opening) {
        this.opening = opening;
    }

    public PhysicalStore toPhysicalStore() {
        PhysicalStore physicalStore = new PhysicalStore();
        BeanUtils.copyProperties(this, physicalStore);
        return physicalStore;
    }

    public static class Builder implements PhysicalStoreBuilder.address, PhysicalStoreBuilder.Optionals {

        private PhysicalStoreEntity physicalStoreEntity;

        public Builder() {
            this.physicalStoreEntity = new PhysicalStoreEntity();
            this.physicalStoreEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public PhysicalStoreBuilder.Optionals address(String address) {
            this.physicalStoreEntity.address = address;
            return this;
        }

        @Override
        public PhysicalStoreBuilder.Optionals size(Integer size) {
            this.physicalStoreEntity.size = size;
            return this;
        }

        @Override
        public PhysicalStoreBuilder.Optionals terrace(Boolean terrace) {
            this.physicalStoreEntity.terrace = terrace;
            return this;
        }

        @Override
        public PhysicalStoreBuilder.Optionals opening(LocalDateTime opening) {
            this.physicalStoreEntity.opening = opening;
            return this;
        }

        @Override
        public PhysicalStoreEntity build() { return this.physicalStoreEntity; }
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (address.equals(((PhysicalStoreEntity) obj).address));
    }

    @Override
    public String toString() {
        return "PhysicalStoreEntity{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", terrace=" + terrace +
                ", opening=" + opening +
                '}';
    }
}
