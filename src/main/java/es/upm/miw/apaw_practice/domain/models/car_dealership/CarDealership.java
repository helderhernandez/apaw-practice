package es.upm.miw.apaw_practice.domain.models.car_dealership;

public class CarDealership {
    private String id;
    private String name;
    private String address;
    private Long telephone;

    public CarDealership() {
        // Empty for framework
    }

    public CarDealership(String id, String name, String address, Long telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
