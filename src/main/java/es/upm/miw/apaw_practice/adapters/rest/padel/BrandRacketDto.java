package es.upm.miw.apaw_practice.adapters.rest.padel;

public class BrandRacketDto {
    private String brand;

    public BrandRacketDto(){
        //For framework
    }
     BrandRacketDto(String brand) {
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
        return "BrandRacketDto{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
