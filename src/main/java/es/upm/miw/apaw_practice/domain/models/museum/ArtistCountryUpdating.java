package es.upm.miw.apaw_practice.domain.models.museum;

public class ArtistCountryUpdating {

    private String id;
    private String country;

    public ArtistCountryUpdating() {
    }

    public ArtistCountryUpdating(String id, String country) {
        this.id = id;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ArtistCountryUpdating{" +
                "id=" + id + "," +
                "country=" + country +
                '}';
    }
} 
