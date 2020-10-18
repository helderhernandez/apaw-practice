package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;

public class DiseaseNameDto {
    String name;

    public DiseaseNameDto() {
        // empty for framework
    }

    public DiseaseNameDto(Disease disease) {
        this.name = disease.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DiseaseNameDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
