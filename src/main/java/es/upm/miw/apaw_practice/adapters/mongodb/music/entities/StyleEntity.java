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

    public  static Builder builder(String name){
        return new Builder(name);
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

    public void fromStyle(Style style){
        BeanUtils.copyProperties(style, this);
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

    public static class Builder {
        private final StyleEntity style;

        public Builder(String name){
            this.style = new StyleEntity();
            this.style.name = name;
        }

        public Builder description(String description){
            this.style.description = description;
            return this;
        }

        public StyleEntity build() {
            return this.style;
        }
    }
}
