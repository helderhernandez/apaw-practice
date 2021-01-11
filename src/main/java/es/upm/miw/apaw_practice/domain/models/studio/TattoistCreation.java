package es.upm.miw.apaw_practice.domain.models.studio;

public class TattoistCreation {
    private String email;
    private String name;
    private String nickname;
    private String phone;
    private String mainStyle;
    private Float ranking;

    public TattoistCreation() {
        // Empty for framework
    }

    public TattoistCreation(String email, String name, String nickname, String phone, String mainStyle, Float ranking) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.mainStyle = mainStyle;
        this.ranking = ranking;
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
        return "TattoistCreation{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", mainStyle='" + mainStyle + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
