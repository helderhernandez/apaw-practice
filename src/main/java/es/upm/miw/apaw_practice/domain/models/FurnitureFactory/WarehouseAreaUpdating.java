package es.upm.miw.apaw_practice.domain.models.FurnitureFactory;


public class WarehouseAreaUpdating {

    private String name;
    private String area;

    public WarehouseAreaUpdating() {
        //empty for framework
    }

    public WarehouseAreaUpdating(String name, String area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public String toString() {
        return "WarehouseAreaUpdating{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
