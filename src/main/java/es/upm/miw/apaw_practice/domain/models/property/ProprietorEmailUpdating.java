package es.upm.miw.apaw_practice.domain.models.property;

public class ProprietorEmailUpdating {
    private String dni;
    private String email;

    public ProprietorEmailUpdating(){
        //empty for framework
    }

    public ProprietorEmailUpdating(String dni, String email) {
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
        return "ProprietorEmailUpdating{" +
                "dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
