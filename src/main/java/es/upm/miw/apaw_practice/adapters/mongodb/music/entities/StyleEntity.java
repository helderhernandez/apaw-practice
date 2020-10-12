package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;


import es.upm.miw.apaw_practice.domain.models.music.Style;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document
public class StyleEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    public  StyleEntity(){
        //Empty for framework
    }


    public StyleEntity(Style style) {
        BeanUtils.copyProperties(style, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    public Style toStyle(){
        Style style = new Style();
        BeanUtils.copyProperties(this, style);
        return style;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((es.upm.miw.apaw_practice.adapters.mongodb.music.entities.StyleEntity)obj).name));
    }

    @Override
    public String toString() {
        return "StyleEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
