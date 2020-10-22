package es.upm.miw.apaw_practice.domain.models.basketball;

public class CoachCreation {
    private String name;
    private String dni;

    public CoachCreation() {
        //Empty constructor for the framework
    }

    public CoachCreation(String name, String dni) {
        this.name = name;
        this.dni = dni;
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

}
