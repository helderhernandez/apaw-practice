package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities;

import es.upm.miw.apaw_practice.domain.models.studio.TattoistCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

@Document
public class TattoistEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String name;
    private String nickname;
    private String phone;
    private String mainStyle;
    private float ranking;

    public TattoistEntity() {
        // Empty for framework
    }

    public TattoistEntity(TattoistCreation tattoistCreation) {
        BeanUtils.copyProperties(tattoistCreation, this);
        this.id = UUID.randomUUID().toString();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TattoistEntity)) return false;
        TattoistEntity that = (TattoistEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
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
