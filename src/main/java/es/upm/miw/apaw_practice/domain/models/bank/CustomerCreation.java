package es.upm.miw.apaw_practice.domain.models.bank;

public class CustomerCreation {
    private String name;
    private String DNI;

    public CustomerCreation(String name, String DNI) {
        this.name = name;
        this.DNI = DNI;
    }

    public CustomerCreation() {
        //Empty for framework
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "CustomerCreation{" +
                "name='" + name + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
