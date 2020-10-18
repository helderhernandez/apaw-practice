package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;

public class AddressStoreDto {
    String address;

    public  AddressStoreDto() {
        //Empty for framework
    }

    public AddressStoreDto(PhysicalStore physicalStore) {
        this.address = physicalStore.getAddress();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressScoreDto{" +
                "address='" + address + '\'' +
                '}';
    }
}
