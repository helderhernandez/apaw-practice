package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;

import java.time.LocalDateTime;

public class BasicPostDto {

    private LocalDateTime postingDate;
    private String content;
    private Integer shared;
    private Integer likes;

    public BasicPostDto() {
        // empty for framework
    }

    BasicPostDto(SocialPost socialPost) {
        this.postingDate = socialPost.getPostingDate();
        this.content = socialPost.getContent();
        this.shared = socialPost.getShared();
        this.likes = socialPost.getLikes();
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
        return "BasicPostDto{" +
                "postingDate=" + postingDate +
                ", content='" + content + '\'' +
                ", shared=" + shared +
                ", likes=" + likes +
                '}';
    }

}
