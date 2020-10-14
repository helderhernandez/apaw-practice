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

    public static SocialPostBuilders.Id builder() {
        return new Builder();
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

    public static class Builder implements SocialPostBuilders.Id, SocialPostBuilders.PostingDate, SocialPostBuilders.Content, SocialPostBuilders.Shared, SocialPostBuilders.Likes, SocialPostBuilders.Optionals {

        private SocialPost socialPost;

        public Builder() {
            this.socialPost = new SocialPost();
        }

        @Override
        public SocialPostBuilders.PostingDate id(String id) {
            this.socialPost.id = id;
            return this;
        }

        @Override
        public SocialPostBuilders.Content postingDate(LocalDateTime postingDate) {
            this.socialPost.postingDate = postingDate;
            return this;
        }

        @Override
        public SocialPostBuilders.Shared content(String content) {
            this.socialPost.content = content;
            return this;
        }

        @Override
        public SocialPostBuilders.Likes shared(Integer shared) {
            this.socialPost.shared = shared;
            return this;
        }

        @Override
        public SocialPostBuilders.Optionals likes(Integer likes) {
            this.socialPost.likes = likes;
            return this;
        }

        @Override
        public SocialPost build() {
            return this.socialPost;
        }
    }

}
