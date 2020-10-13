package es.upm.miw.apaw_practice.domain.models.basketball;

public class MemberTeam {

    private String id;
    private String name;
    private String surname;
    private String dni;
    private Boolean available;

    public MemberTeam() {
        //Empty constructor for the framework
    }

    public MemberTeam(String id, String name, String surname, String dni, Boolean available) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.available = available;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "MemberTeam{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", available=" + available +
                '}';
    }
}
