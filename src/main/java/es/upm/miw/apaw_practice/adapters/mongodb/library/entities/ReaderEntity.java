package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class ReaderEntity {
    @Id
    private String id;
    private String name;
    private String sex;

    @Indexed(unique = true)
    private String DNI;
    private String phone;
    private String email;
    public  ReaderEntity(){
        //empty for framework
    }
    public ReaderEntity(String id, String name, String sex, String DNI, String phone, String email) {
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

    public Reader toReader(){
        Reader reader=new Reader();
        BeanUtils.copyProperties(this,reader);
        return  reader;
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (DNI.equals(((ReaderEntity) obj).DNI));
    }

    @Override
    public int hashCode() {
        return DNI.hashCode();
    }

    @Override
    public String toString() {
        return "ReaderEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", DNI='" + DNI + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
