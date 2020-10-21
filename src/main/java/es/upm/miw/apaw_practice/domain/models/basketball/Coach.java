package es.upm.miw.apaw_practice.domain.models.basketball;

public class Coach {
    private String id;
    private String name;
    private String dni;

    public Coach() {
        //Empty constructor for the framework
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

}
