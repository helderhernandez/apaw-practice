package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

public class BiographyDto {

    private String biography;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "BiographyDto{" +
                "biography='" + biography + '\'' +
                '}';
    }

}
