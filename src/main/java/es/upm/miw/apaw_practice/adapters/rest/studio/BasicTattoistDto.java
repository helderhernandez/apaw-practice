package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;

public class BasicTattoistDto {

    private String id;
    private String nickname;
    private String mainStyle;

    public BasicTattoistDto() {
        // Empty for framework
    }

    public BasicTattoistDto(Tattoist tattoist) {
        this.id = tattoist.getId();
        this.nickname = tattoist.getNickname();
        this.mainStyle = tattoist.getMainStyle();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMainStyle() {
        return mainStyle;
    }

    public void setMainStyle(String mainStyle) {
        this.mainStyle = mainStyle;
    }

    @Override
    public String toString() {
        return "BasicTattoistDto{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", style='" + mainStyle + '\'' +
                '}';
    }
}
