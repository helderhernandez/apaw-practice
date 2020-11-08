package es.upm.miw.apaw_practice.domain.models.videoclub;

public class FilmCategory {

    private String reference;
    private String name;
    private Boolean plus18;

    public FilmCategory() {
        // empty from framework
    }

    public FilmCategory(String reference, String name, Boolean plus18) {
        this.reference = reference;
        this.name = name;
        this.plus18 = plus18;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlus18() {
        return plus18;
    }

    public void setPlus18(Boolean plus18) {
        this.plus18 = plus18;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", plus18=" + plus18 +
                '}';
    }
}
