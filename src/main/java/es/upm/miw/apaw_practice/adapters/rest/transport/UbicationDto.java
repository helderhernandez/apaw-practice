package es.upm.miw.apaw_practice.adapters.rest.transport;

public class UbicationDto {
    private String ubication;

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    @Override
    public String toString() {
        return "UbicationDto{" +
                "ubication='" + ubication + '\'' +
                '}';
    }
}
