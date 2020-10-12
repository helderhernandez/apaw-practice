package es.upm.miw.apaw_practice.domain.models.FurnitureFactory;

public class FurnitureItem {
    private String name;

    public FurnitureItem() {
        //empty for framework
    }

    public FurnitureItem(String name) {
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
