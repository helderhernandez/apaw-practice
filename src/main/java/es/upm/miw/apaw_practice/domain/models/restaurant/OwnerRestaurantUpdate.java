package es.upm.miw.apaw_practice.domain.models.restaurant;

public class OwnerRestaurantUpdate {
    private String name;
    private String familyName;

    public OwnerRestaurantUpdate() {
        //Empty for framework
    }

    public OwnerRestaurantUpdate(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "OwnerRestaurantUpdate{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
