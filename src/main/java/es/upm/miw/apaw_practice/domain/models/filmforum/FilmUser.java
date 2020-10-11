package es.upm.miw.apaw_practice.domain.models.filmforum;

public class FilmUser {
    private String username;
    private String email;

    public FilmUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FilmUser{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
