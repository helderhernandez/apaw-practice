package es.upm.miw.apaw_practice.domain.models.property;

public class Proprietor {
    private String name;
    private String dni;
    private String age;
    private String phone;
    private String email;

    public Proprietor(){

    }

    public Proprietor(String name, String dni, String age, String phone, String email) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proprietor{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
