package es.upm.miw.apaw_practice.adapters.rest.article;

public class NewName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewName{" +
                "name='" + name + '\'' +
                '}';
    }
}
