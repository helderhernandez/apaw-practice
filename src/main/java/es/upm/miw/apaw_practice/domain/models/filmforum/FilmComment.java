package es.upm.miw.apaw_practice.domain.models.filmforum;

import java.time.LocalDateTime;

public class FilmComment {
    private String id;
    private FilmUser user;
    private String content;
    private Integer punctuation;
    private LocalDateTime createdAt;

    public FilmComment(String id, FilmUser user, String content, Integer punctuation, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.punctuation = punctuation;
        this.createdAt = createdAt;
    }

    public FilmUser getUser() {
        return user;
    }

    public void setUser(FilmUser user) {
        this.user = user;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FilmComment{" +
                "user=" + user +
                ", content='" + content + '\'' +
                ", punctuation=" + punctuation +
                ", createdAt=" + createdAt +
                '}';
    }
}
