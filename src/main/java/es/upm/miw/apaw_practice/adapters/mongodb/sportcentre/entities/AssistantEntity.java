package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AssistantEntity {

    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer phone;


    public AssistantEntity(String id, String name, String lastName, Integer phone){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Assistant toAssistant() {
        Assistant assistant = new Assistant();
        BeanUtils.copyProperties(this, assistant);
        return assistant;
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return obj != null && obj.getClass() == this.getClass() && (this.id.equals(((AssistantEntity) obj).id));
    }

    @Override
    public String toString(){
        return "AssistantEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", last name=" + lastName +
                ", phone=" + phone +
                '}';
    }

}
