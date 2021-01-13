package es.upm.miw.apaw_practice.domain.models.studio;

public class TattoistItem {

    private String nickname;

    public TattoistItem() {
        // Empty for framework
    }

    public TattoistItem(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "TattoistItem{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
