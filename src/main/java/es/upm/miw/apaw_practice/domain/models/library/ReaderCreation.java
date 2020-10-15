package es.upm.miw.apaw_practice.domain.models.library;

public class ReaderCreation {
    private String id;
    private String name;
    private String sex;
    private String DNI;
    private String phone;
    private String email;

    public ReaderCreation(){
        //empty for framework
    }
    public ReaderCreation(String name, String sex, String DNI, String phone, String email) {
        this.name = name;
        this.sex = sex;
        this.DNI = DNI;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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
        return "ReaderCreation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", DNI='" + DNI + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
