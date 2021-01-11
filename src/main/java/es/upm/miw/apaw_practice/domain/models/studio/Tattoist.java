package es.upm.miw.apaw_practice.domain.models.studio;


public class Tattoist {
    private String id;
    private String email;
    private String name;
    private String nickname;
    private String phone;
    private String mainStyle;
    private Float ranking;

    public Tattoist() {
        // Empty for framework
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMainStyle() {
        return mainStyle;
    }

    public void setMainStyle(String mainStyle) {
        this.mainStyle = mainStyle;
    }

    public Float getRanking() {
        return ranking;
    }

    public void setRanking(Float ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "TattoistEntity{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickname=" + nickname +
                ", phone=" + phone +
                ", ranking=" + ranking +
                ", mainStyle='" + mainStyle + '\'' +
                '}';
    }
}
