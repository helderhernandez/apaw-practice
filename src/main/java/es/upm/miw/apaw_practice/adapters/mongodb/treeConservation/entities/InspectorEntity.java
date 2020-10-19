package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspector;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class InspectorEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;

    public InspectorEntity() {
        //empty from framework
    }

    //    public InspectorEntity(String dni, String firstName, String lastName, Integer age, String email, String phoneNumber) {
//        this.id = UUID.randomUUID().toString();
//        this.dni = dni;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }
    public static InspectorBuilders.Dni builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Inspector toInspector() {
        Inspector inspector = new Inspector();
        BeanUtils.copyProperties(this, inspector);
        return inspector;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (this.dni.equals(((InspectorEntity) o).getDni()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "InspectorEntity{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder implements InspectorBuilders.Dni,
            InspectorBuilders.FirstName, InspectorBuilders.LastName,
            InspectorBuilders.Age, InspectorBuilders.Optionals {


        private final InspectorEntity inspector;

        public Builder() {
            this.inspector = new InspectorEntity();
            BeanUtils.copyProperties(inspector, this);
            this.inspector.id = UUID.randomUUID().toString();

        }

        @Override
        public InspectorBuilders.FirstName dni(String dni) {
            this.inspector.dni = dni;
            return this;
        }

        @Override
        public InspectorBuilders.LastName firstName(String firstName) {
            this.inspector.firstName = firstName;
            return this;
        }

        @Override
        public InspectorBuilders.Age lastName(String lastName) {
            this.inspector.lastName = lastName;
            return this;
        }

        @Override
        public InspectorBuilders.Optionals age(Integer age) {
            this.inspector.age = age;
            return this;
        }

        @Override
        public InspectorBuilders.Optionals email(String email) {
            this.inspector.email = email;
            return this;
        }

        @Override
        public InspectorBuilders.Optionals phoneNumber(String phoneNumber) {
            this.inspector.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public InspectorEntity build() {
            return this.inspector;
        }

    }
}
