package es.upm.miw.apaw_practice.domain.models.school;

public class StudentEmailUpdating {
    private String dni;
    private String email;

    public StudentEmailUpdating() {
        //empty for framework
    }

    public StudentEmailUpdating(String dni, String email) {
        this.dni = dni;
        this.email = email;
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
        return "StudentEmailUpdating{" +
                "dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
