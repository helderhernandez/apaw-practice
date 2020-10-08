package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

public class BrandDto {
    private String brand;

    public BrandDto() {
        // empty for framework
    }

    public BrandDto(String brand) {
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
        return "BrandDto{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
