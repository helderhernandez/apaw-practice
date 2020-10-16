package es.upm.miw.apaw_practice.domain.models.videoclub;

public class FilmCategoryAdultUpdating {
    private String reference;
    private Boolean plus18;

    public FilmCategoryAdultUpdating() {
        //empty from framework
    }

    public FilmCategoryAdultUpdating(String reference, Boolean plus18) {
        this.reference = reference;
        this.plus18 = plus18;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Boolean getPlus18() {
        return plus18;
    }

    public void setPlus18(Boolean plus18) {
        this.plus18 = plus18;
    }

    @Override
    public String toString() {
        return "FilmCategoryAdultUpdating{" +
                "reference='" + reference + '\'' +
                ", plus18=" + plus18 +
                '}';
    }
}
