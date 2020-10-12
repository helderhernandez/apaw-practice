package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.time.LocalDateTime;

public class SocialPost {

    private String id;
    private LocalDateTime postingDate;
    private String content;
    private Integer shared;
    private Integer likes;

    public SocialPost() {
        //empty for framework
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
    public String toString() {
        return "SocialPost{" +
                "id='" + id + '\'' +
                ", postingDate=" + postingDate +
                ", content='" + content + '\'' +
                ", shared=" + shared +
                ", likes=" + likes +
                '}';
    }

}
