package es.upm.miw.apaw_practice.domain.models.museum;


public class Artist {
    private String id;
    private String name;
    private String surname;
    private String county;

    public Artist() { }

    public Artist(String id, String name, String surname, String county) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.county = county;
    }


    //#region Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    //#endregion

    //#region Override methods

    @Override
    public String toString() {
        return String.format(
                "ArtistEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "surname=%s, " +
                        "country=%s, " +
                        "}",
                id,
                name,
                surname,
                county
        );
    }
    //#endregion

    //#region Builder pattern
    public static ArtistsBuilder.Id builder(){
        return new Builder();
    }

    public static class Builder implements ArtistsBuilder.Id, ArtistsBuilder.Name, ArtistsBuilder.Surname, ArtistsBuilder.Country
    {
        private Artist artist;

        public Builder() {
            this.artist = new Artist();
        }

        @Override
        public ArtistsBuilder.Name id(String id) {
            this.artist.id = id;
            return this;
        }

        @Override
        public ArtistsBuilder.Surname name(String name) {
            this.artist.name = name;
            return this;
        }

        @Override
        public ArtistsBuilder.Country surname(String surname) {
            this.artist.surname = surname;
            return this;
        }

        @Override
        public Artist build(String country) {
            this.artist.county = country;
            return artist;
        }
    }

    //#endregion
}
