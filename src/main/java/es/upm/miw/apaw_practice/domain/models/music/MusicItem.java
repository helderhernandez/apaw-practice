package es.upm.miw.apaw_practice.domain.models.music;

public class MusicItem {
    private String name;

    public MusicItem(){
        //empty for framework
    }

    public MusicItem(String name) {
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
        return "MusicItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
