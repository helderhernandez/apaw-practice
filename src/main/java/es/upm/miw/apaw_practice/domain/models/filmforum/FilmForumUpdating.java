package es.upm.miw.apaw_practice.domain.models.filmforum;

public class FilmForumUpdating {
    String name;
    Boolean isForAllPublic;

    public FilmForumUpdating() {
        // Empty for Framework
    }

    public FilmForumUpdating(String name, Boolean isForAllPublic) {
        this.name = name;
        this.isForAllPublic = isForAllPublic;
    }

    public Boolean isForAllPublic() {
        return isForAllPublic;
    }

    public String getName() {
        return name;
    }

    public void setForAllPublic(Boolean forAllPublic) {
        isForAllPublic = forAllPublic;
    }

    public void setName(String name) {
        this.name = name;
    }
}
