package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

public interface InstructorComponent {

    void add(InstructorComponent instructorComponent);

    void remove(InstructorComponent instructorComponent);

    String view();

    Boolean isComposite(InstructorComponent instructorComponent);
}