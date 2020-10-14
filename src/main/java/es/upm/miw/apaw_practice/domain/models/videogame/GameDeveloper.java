package es.upm.miw.apaw_practice.domain.models.videogame;

public class GameDeveloper {

    private String id;
    private String name;
    private String email;
    private Integer phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Builder builder(String id){
        return new Builder(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "GameDeveloper{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static class Builder {
        private GameDeveloper gameDeveloper;

        public Builder(String id) {
            gameDeveloper = new GameDeveloper();
            gameDeveloper.setId(id);
        }

        public Builder name(String name) {
            gameDeveloper.setName(name);
            return this;
        }

        public Builder email(String email) {
            gameDeveloper.setEmail(email);
            return this;
        }

        public Builder phone(Integer phone) {
            gameDeveloper.setPhone(phone);
            return this;
        }

        public GameDeveloper build(){
            return gameDeveloper;
        }

    }

}

