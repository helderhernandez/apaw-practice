package es.upm.miw.apaw_practice.domain.models.school;

public class SubjectItem {
    private String name;

    public SubjectItem() {
        //empty for framework
    }

    public SubjectItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
