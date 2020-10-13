package es.upm.miw.apaw_practice.domain.models.article;

public class Essay {
    private String id;
    private String name;

    public Essay() {
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
