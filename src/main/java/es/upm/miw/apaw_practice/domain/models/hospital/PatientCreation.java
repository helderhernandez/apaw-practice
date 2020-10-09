package es.upm.miw.apaw_practice.domain.models.hospital;

import java.util.Arrays;

public class PatientCreation {

    private String dni;
    private String name;
    private String surname;
    private String[] pathologies;

    public PatientCreation(String dni, String name, String surname, String[] pathologies) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.pathologies = pathologies;
    }

    public PatientCreation() {
        //Empty for framework
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String[] getPathologies() {
        return pathologies;
    }

    public void setPathologies(String[] pathologies) {
        this.pathologies = pathologies;
    }

    @Override
    public String toString() {
        return "PatientCreation{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pathologies=" + Arrays.toString(pathologies) +
                '}';
    }
}
