package es.upm.miw.apaw_practice.domain.models.library;

public class NameUpdating {
    private String name;

    public NameUpdating(String name) {
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
        return "NameUpdating{" +
                "name='" + name + '\'' +
                '}';
    }
}
