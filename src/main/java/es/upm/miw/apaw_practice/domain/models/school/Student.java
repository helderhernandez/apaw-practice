package es.upm.miw.apaw_practice.domain.models.school;

public class Student {
    private String id;
    private String name;
    private String familyName;
    private Boolean graduate;
    private String dni;
    private String email;

    public Student() {
        //empty from framework
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Boolean isGraduate() {
        return graduate;
    }

    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
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
        return "StudentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", graduate=" + graduate +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
