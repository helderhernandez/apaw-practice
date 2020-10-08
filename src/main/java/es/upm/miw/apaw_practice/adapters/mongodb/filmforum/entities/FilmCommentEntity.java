package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class FilmCommentEntity {
    @Id
    private String id;
    @DBRef
    private FilmUserEntity commentUser;
    private String content;
    private Integer punctuation;
    private LocalDateTime createdAt;

    public FilmCommentEntity() {
        // Framework needs it
    }

    public FilmCommentEntity(String id, FilmUserEntity commentUser, String content, Integer punctuation, LocalDateTime createdAt) {
        this.id = id;
        this.commentUser = commentUser;
        this.content = content;
        this.punctuation = punctuation;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FilmUserEntity getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(FilmUserEntity commentUser) {
        this.commentUser = commentUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Integer punctuation) {
        this.punctuation = punctuation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FilmCommentEntity) obj).id));
    }

    @Override
    public String toString() {
        return "FilmCommentEntity{" +
                "id='" + id + '\'' +
                ", commentUser=" + commentUser +
                ", content='" + content + '\'' +
                ", punctuation=" + punctuation +
                ", createdAt=" + createdAt +
                '}';
    }
}
