package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities;

import es.upm.miw.apaw_practice.domain.models.studio.Consumer;
import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class ConsumerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String name;
    private String phone;
    private String favoriteStyle;

    public ConsumerEntity() {
        // Empty for framework
    }

    public ConsumerEntity(String email, String name, String phone, String favoriteStyle) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.favoriteStyle = favoriteStyle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFavoriteStyle() {
        return favoriteStyle;
    }

    public void setFavoriteStyle(String favoriteStyle) {
        this.favoriteStyle = favoriteStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumerEntity)) return false;
        ConsumerEntity that = (ConsumerEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "ConsumerEntity{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", favoriteStyle='" + favoriteStyle + '\'' +
                '}';
    }

    public Consumer toConsumer() {
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(this, consumer);
        return consumer;
    }
}
