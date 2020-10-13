package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import es.upm.miw.apaw_practice.domain.models.music.Music;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class MusicEntity {
    @DBRef
    private StyleEntity styleEntity;
    @Id
    private String id;
    private String name;
    private String description;

    public MusicEntity(){
        //Empty for framework
    }

    public MusicEntity(StyleEntity styleEntity, String name, String description) {
        this.styleEntity = styleEntity;
        this.name = name;
        this.description = description;
    }


    public StyleEntity getStyleEntity() { return styleEntity; }

    public void setStyleEntity(StyleEntity styleEntity) { this.styleEntity = styleEntity; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Music toMusic(){
        Music music = new Music();
        BeanUtils.copyProperties(this, music);
        return music;
    }

    @Override
    public String toString() {
        return "MusicEntity{" +
                "styleEntity=" + styleEntity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
