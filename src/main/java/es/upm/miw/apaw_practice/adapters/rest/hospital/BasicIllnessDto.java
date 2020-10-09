package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Illness;

public class BasicIllnessDto {
    private String id;
    private Boolean contagious;

    public BasicIllnessDto() {
        //empty for framework
    }

    public BasicIllnessDto(Illness illness) {
        this.id = illness.getId();
        this.contagious = illness.getContagious();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getContagious() {
        return contagious;
    }

    public void setContagious(Boolean contagious) {
        this.contagious = contagious;
    }

    @Override
    public String toString() {
        return "BasicIllnessDto{" +
                "id='" + id + '\'' +
                ", contagious=" + contagious +
                '}';
    }
}
