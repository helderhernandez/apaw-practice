package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FilmUserEntity {
    @Id
    private String id;
    private String username;
    private String email;

    public FilmUserEntity() {
        // Framework needs it
    }

    public FilmUserEntity(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FilmUser toFilmUser() {
        return new FilmUser(id, username, email);
    }

    public void fromFilmUser(FilmUser user) {
        BeanUtils.copyProperties(user, this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FilmUserEntity) obj).id));
    }

    @Override
    public String toString() {
        return "FilmUserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
