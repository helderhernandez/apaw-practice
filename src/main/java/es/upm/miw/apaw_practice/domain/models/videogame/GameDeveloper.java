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

    public static GameDeveloperBuilders.Id builder() {
        return new Builder();
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

    public static class Builder implements GameDeveloperBuilders.Id, GameDeveloperBuilders.Name,
            GameDeveloperBuilders.EmailDeveloper, GameDeveloperBuilders.Phone, GameDeveloperBuilders.Build {


            private GameDeveloper gameDeveloper;

        public Builder() {
            gameDeveloper = new GameDeveloper();
        }

            @Override
            public GameDeveloperBuilders.Name id (String id){
            gameDeveloper.setId(id);
            return this;
        }

            @Override
            public GameDeveloperBuilders.EmailDeveloper name (String name){
            gameDeveloper.setName(name);
            return this;
        }

            @Override
            public GameDeveloperBuilders.Phone email (String email){
            gameDeveloper.setEmail(email);
            return this;
        }

            @Override
            public GameDeveloperBuilders.Build phone (Integer phone){
            gameDeveloper.setPhone(phone);
            return this;
        }

            @Override
            public GameDeveloper build () {
            return gameDeveloper;
        }

        }

    }

