package es.upm.miw.apaw_practice.domain.models.school;

public class TeacherCreation {
    private String id;
    private String name;
    private String familyName;
    private Boolean intern;
    private String dni;
    private String email;

    public TeacherCreation() {
        //empty from framework
    }

    public TeacherCreation(String name, String familyName, Boolean intern, String dni, String email) {
        this.name = name;
        this.familyName = familyName;
        this.intern = intern;
        this.dni = dni;
        this.email = email;
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

    public Boolean isIntern() {
        return intern;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", intern=" + intern +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
