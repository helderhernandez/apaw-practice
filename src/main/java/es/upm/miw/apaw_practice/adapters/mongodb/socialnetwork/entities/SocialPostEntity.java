package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class SocialPostEntity {

    @Id
    private String id;
    private LocalDateTime postingDate;
    private String content;
    private Integer shared;
    private Integer likes;

    public SocialPostEntity() {
        //empty from framework
    }

    public SocialPostEntity(String content, Integer shared, Integer likes) {
        this.id = UUID.randomUUID().toString();
        this.postingDate = LocalDateTime.now();
        this.content = content;
        this.shared = shared;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getShared() {
        return shared;
    }

    public void setShared(Integer shared) {
        this.shared = shared;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((SocialPostEntity) obj).id));
    }

    @Override
    public String toString() {
        return "SocialPostEntity{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", postingDate='" + postingDate + '\'' +
                ", shared='" + shared + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }

}
