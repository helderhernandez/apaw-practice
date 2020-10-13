package es.upm.miw.apaw_practice.domain.models.treeConservation;

public class DiseaseCreation {
    private String name;
    private String description;

    public DiseaseCreation() {
        //empty for framework
    }

    public DiseaseCreation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DiseaseCreation{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
