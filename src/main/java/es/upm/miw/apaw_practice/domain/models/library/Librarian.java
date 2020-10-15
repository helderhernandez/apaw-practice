package es.upm.miw.apaw_practice.domain.models.library;

import java.util.Objects;

public class Librarian {
    private String id;
    private String name;
    private String phone;
    private Order order;

    public Librarian(){
        //empty from framework
    }
    public Librarian(String id, String name, String phone, Order order) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", order=" + order +
                '}';
    }
}
