package es.upm.miw.apaw_practice.domain.models.property;

public class PropertyStaffCreation {
    private String id;
    private String name;
    private String dni;
    private String description;

    public PropertyStaffCreation() {
        //empty from framework
    }

    public PropertyStaffCreation(String name, String dni, String description) {
        this.name = name;
        this.dni = dni;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PropertyStaff{" +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
