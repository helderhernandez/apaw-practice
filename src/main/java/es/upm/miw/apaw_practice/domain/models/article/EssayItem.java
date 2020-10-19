package es.upm.miw.apaw_practice.domain.models.article;

public class EssayItem {
    private String name;

    public EssayItem(){
        //empty for framework
    }

    public EssayItem(String name) {
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
        return "EssayItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
