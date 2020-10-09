package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class LibrarianEntity {
    @Id
    private String id;
    private String name;
    private String phone;

    @DBRef
    private List<OrderEntity> orderEntity;

    public  LibrarianEntity(){
        //empty for framework
    }
    public LibrarianEntity(String id, String name, String phone, List<OrderEntity> orderEntity) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.orderEntity = orderEntity;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
    }

    public Librarian toLibrarian(){
        Librarian librarian=new Librarian();
        BeanUtils.copyProperties(this, librarian);
        return librarian;
    }
    @Override
    public String toString() {
        return "LibrarianEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", orderEntity=" + orderEntity +
                '}';
    }
}
