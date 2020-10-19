package es.upm.miw.apaw_practice.domain.models.article;

public class TypeDescriptionUpdating {
    private String name;
    private String description;

    public TypeDescriptionUpdating(){
        //empty for framework
    }

    public TypeDescriptionUpdating(String name, String description) {
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
        return "TypeDescriptionUpdating{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
