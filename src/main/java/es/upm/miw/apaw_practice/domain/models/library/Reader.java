package es.upm.miw.apaw_practice.domain.models.library;

import java.util.Objects;

public class Reader {
    private String id;
    private String name;
    private String sex;
    private String DNI;
    private String phone;
    private String email;

    public  Reader(){
        //empty from framework
    }
    public Reader(String id, String name, String sex, String DNI, String phone, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.DNI = DNI;
        this.phone = phone;
        this.email = email;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
