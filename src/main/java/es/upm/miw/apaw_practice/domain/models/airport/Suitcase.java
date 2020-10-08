package es.upm.miw.apaw_practice.domain.models.airport;

public class Suitcase {

    private String color;
    private Double size;
    private String manufacturer;

    public Suitcase(String color, Double size, String manufacturer) {
        this.color = color;
        this.size = size;
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Suitcase{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
