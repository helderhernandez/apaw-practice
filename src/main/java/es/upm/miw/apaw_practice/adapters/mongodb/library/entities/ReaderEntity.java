package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

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
    
    public static ReaderBuilders.Name builder(){
        return new Builder();
    }

    public static class Builder implements ReaderBuilders.Name,ReaderBuilders.Sex,ReaderBuilders.DNI,ReaderBuilders.Phone,ReaderBuilders.Optionals{

        private final ReaderEntity reader;

        public Builder() {
            this.reader=new ReaderEntity();
            BeanUtils.copyProperties(reader,this);
            this.reader.id=UUID.randomUUID().toString();
        }

        @Override
        public ReaderBuilders.Sex name(String name) {
            this.reader.name=name;
            return this;
        }

        @Override
        public ReaderBuilders.DNI sex(String sex) {
            this.reader.sex=sex;
            return this;
        }

        @Override
        public ReaderBuilders.Phone dni(String dni) {
            this.reader.DNI=dni;
            return this;
        }

        @Override
        public ReaderBuilders.Optionals phone(String phone) {
            this.reader.phone=phone;
            return this;
        }

        @Override
        public ReaderBuilders.Optionals email(String email) {
            this.reader.email=email;
            return this;
        }

        @Override
        public ReaderEntity build() {
            return this.reader;
        }
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
