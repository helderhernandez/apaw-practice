package es.upm.miw.apaw_practice.domain.models.studio;

public class Consumer {

    private String id;
    private String email;
    private String name;
    private String phone;
    private String favoriteStyle;

    public Consumer() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFavoriteStyle() {
        return favoriteStyle;
    }

    public void setFavoriteStyle(String favoriteStyle) {
        this.favoriteStyle = favoriteStyle;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", favoriteStyle='" + favoriteStyle + '\'' +
                '}';
    }
}
