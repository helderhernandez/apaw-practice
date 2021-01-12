package es.upm.miw.apaw_practice.domain.models.adCampaign;

public class Promotion {

    private String id;
    private String title;
    private String header;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
