package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

import java.util.ArrayList;
import java.util.List;

public class InstructorComposite  implements InstructorComponent{

    private List<InstructorComponent> instructorComponentList;

    public InstructorComposite() {
        this.instructorComponentList = new ArrayList<>();
    }

    public InstructorComposite(List<InstructorComponent> instructorComponentList) {
        this.instructorComponentList = instructorComponentList;
    }

    @Override
    public void add(InstructorComponent instructorComponent) {
        this.instructorComponentList.add(instructorComponent);
    }

    @Override
    public void remove(InstructorComponent instructorComponent) {
        this.instructorComponentList.remove(instructorComponent);
    }

    @Override
    public String view() {
        StringBuilder instructors = new StringBuilder();
        instructors.append("[");
        for (InstructorComponent instructorComponent: this.instructorComponentList) {
            instructors.append(instructorComponent.view());
        }
        instructors.append("]");
        return instructors.toString();
    }

    @Override
    public Boolean isComposite(InstructorComponent instructorComponent) {
        return true;
    }

}