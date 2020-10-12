package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities;

import es.upm.miw.apaw_practice.domain.models.veterinary.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class ClientEntity {

    @Id
    private String id;
    private String name;
    private String address;
    private String phone;

    public ClientEntity() {
        //Empty for framework
    }

    public ClientEntity(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static ClientBuilder.Id builder() {
        return new Builder();
    }

    public static class Builder implements ClientBuilder.Id, ClientBuilder.Name,
            ClientBuilder.Address, ClientBuilder.Phone, ClientBuilder.EndBuilder {

        private ClientEntity clientEntity;

        public Builder() {
            this.clientEntity = new ClientEntity();
        }


        public ClientBuilder.Name id(String id) {
            this.clientEntity.id = id;
            return this;
        }

        @Override
        public ClientBuilder.Address name(String name) {
            this.clientEntity.name = name;
            return this;
        }

        @Override
        public ClientBuilder.Phone address(String address) {
            this.clientEntity.address = address;
            return this;
        }

        public ClientBuilder.EndBuilder phone(String phone) {
            this.clientEntity.phone = phone;
            return this;
        }

        public ClientEntity build() {
            return this.clientEntity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Client toClient() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }
}
