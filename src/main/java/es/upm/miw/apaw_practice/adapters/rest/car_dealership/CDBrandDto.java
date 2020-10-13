package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

public class CDBrandDto {
    private String brand;

    public CDBrandDto() {
        // Empty for framework
    }

    public CDBrandDto(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CDBrandDto{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
