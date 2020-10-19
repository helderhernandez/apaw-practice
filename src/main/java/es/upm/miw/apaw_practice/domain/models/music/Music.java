package es.upm.miw.apaw_practice.domain.models.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.StyleEntity;

import java.util.List;

public class Music {

    private String id;
    private List<StyleEntity> styleEntity;
    private String name;
    private String description;

    public Music() {
        //Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<StyleEntity> getStyleEntity() { return styleEntity; }

    public void setStyleEntity(List<StyleEntity> styleEntity) { this.styleEntity = styleEntity; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id='" + id + '\'' +
                ", styleEntity=" + styleEntity +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}