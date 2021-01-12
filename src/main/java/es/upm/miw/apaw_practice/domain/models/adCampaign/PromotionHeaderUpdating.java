package es.upm.miw.apaw_practice.domain.models.adCampaign;

public class PromotionHeaderUpdating {
    private String id;
    private String header;

    public PromotionHeaderUpdating() {
        //empty for framework
    }

    public PromotionHeaderUpdating(String id, String header) {
        this.id = id;
        this.header = header;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "PromotionHeaderUpdating{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                '}';
    }
}
