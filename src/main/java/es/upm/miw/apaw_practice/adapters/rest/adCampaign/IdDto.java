package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

public class IdDto {
    private String id;

    public IdDto() {
        //empty for framework
    }

    public IdDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
