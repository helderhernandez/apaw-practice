package es.upm.miw.apaw_practice.domain.models.race;

public class RunnerProfessionalUpdating {

    private String dni;
    private Boolean professional;

    public RunnerProfessionalUpdating() {
        // empty for framework
    }

    public RunnerProfessionalUpdating(String dni, Boolean professional) {
        this.dni = dni;
        this.professional = professional;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getProfessional() {
        return professional;
    }

    public void setProfessional(Boolean professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "RunnerProfessionalUpdating{" +
                "dni='" + dni + '\'' +
                ", professional=" + professional +
                '}';
    }
}
