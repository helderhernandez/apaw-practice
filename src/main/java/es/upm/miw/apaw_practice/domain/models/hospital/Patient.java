package es.upm.miw.apaw_practice.domain.models.hospital;

import java.util.Arrays;
import java.util.List;

public class Patient {

    private String id;
    private String dni;
    private String name;
    private String surname;
    private String [] pathologies;
    private List<Illness> illness;

    public Patient(){
        //Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Illness> getIllness() {
        return illness;
    }

    public void setIllness(List<Illness> illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pathologies=" + Arrays.toString(pathologies) +
                ", illness=" + illness +
                '}';
    }
}
