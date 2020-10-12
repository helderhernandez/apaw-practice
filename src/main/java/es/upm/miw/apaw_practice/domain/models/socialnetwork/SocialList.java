package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.util.List;

public class SocialList {

    private String id;
    private String name;
    private String description;
    private Boolean personal;
    private List<SocialUser> socialUsers;

    public SocialList() {
        //empty for framework
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public List<SocialUser> getSocialUsers() {
        return socialUsers;
    }

    public void setSocialUsers(List<SocialUser> socialUsers) {
        this.socialUsers = socialUsers;
    }

    @Override
    public String toString() {
        return "SocialList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", personal=" + personal +
                ", socialUsers=" + socialUsers +
                '}';
    }

}
