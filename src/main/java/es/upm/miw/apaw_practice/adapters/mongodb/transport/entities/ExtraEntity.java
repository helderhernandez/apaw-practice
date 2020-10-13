package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ExtraEntity {
    @Id
    private String id;
    private Integer workedHours;
    private Boolean paid;

    public ExtraEntity() {
        //empty for framework
    }

    public ExtraEntity(String id) {
        this.id = id;
        this.workedHours = 0;
        this.paid = false;
    }

    public static ExtraBuilder builder(String id) {
        return new ExtraBuilder(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ExtraEntity) obj).id));
    }

    @Override
    public String toString() {
        return "ExtraEntity{" +
                "id='" + id + '\'' +
                ", workedHours=" + workedHours +
                ", paid=" + paid +
                '}';
    }

    public void fromStudent(Extra extra) {
        BeanUtils.copyProperties(extra, this);
    }

    public Extra toExtra() {
        Extra extra = new Extra();
        BeanUtils.copyProperties(this, extra);
        return extra;
    }

    public static class ExtraBuilder {
        private final ExtraEntity extraEntity;

        private ExtraBuilder(String id) {
            this.extraEntity = new ExtraEntity(id);
        }

        public ExtraBuilder workedHours(Integer workedHours) {
            this.extraEntity.workedHours = workedHours;
            return this;
        }

        public ExtraBuilder paid(Boolean paid) {
            this.extraEntity.paid = paid;
            return this;
        }

        public ExtraEntity build() {
            return this.extraEntity;
        }
    }
}
