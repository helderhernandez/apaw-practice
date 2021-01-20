package es.upm.miw.apaw_practice.adapters.rest.museum;

public class ArtRestorerJobTitleDto {
    private String artRestorerJobTitle;

    public ArtRestorerJobTitleDto() {
    }

    public ArtRestorerJobTitleDto(String artRestorerJobTitle) {
        this.artRestorerJobTitle = artRestorerJobTitle;
    }

    public String getArtRestorerJobTitle() {
        return artRestorerJobTitle;
    }

    public void setArtRestorerJobTitle(String artRestorerJobTitle) {
        this.artRestorerJobTitle = artRestorerJobTitle;
    }

    @Override
    public String toString() {
        return "ArtRestorerJobTitleDto{" +
                "artRestorerJobTitle='" + artRestorerJobTitle + '\'' +
                '}';
    }
}
