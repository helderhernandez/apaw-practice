package es.upm.miw.apaw_practice.domain.models.treeConservation;

public class InspectorName {
    private String dni;
    private String firstName;
    private String lastName;

    public InspectorName() {
        //empty for framework
    }

    public InspectorName(Inspector inspector) {
        this.dni = inspector.getDni();
        this.firstName = inspector.getFirstName();
        this.lastName = inspector.getLastName();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "InspectorName{" +
                "dni='" + dni + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
