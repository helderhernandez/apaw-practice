package es.upm.miw.apaw_practice.domain.models.transittaxes;

public class Owner {

    private String name;
    private String familyName;
    private String dni;

    public Owner() {
        //empty from framework
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
