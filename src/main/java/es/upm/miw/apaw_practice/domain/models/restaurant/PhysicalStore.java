package es.upm.miw.apaw_practice.domain.models.restaurant;

import java.time.LocalDateTime;

public class PhysicalStore {
    private String address;
    private Integer size;
    private Boolean terrace;
    private LocalDateTime opening;

    public PhysicalStore(){
        //Empty for framework
    }

    public PhysicalStore(String address, Integer size, Boolean terrace, LocalDateTime opening) {
        this.address = address;
        this.size = size;
        this.terrace = terrace;
        this.opening = opening;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getTerrace() {
        return terrace;
    }

    public void setTerrace(Boolean terrace) {
        this.terrace = terrace;
    }

    public LocalDateTime getOpening() {
        return opening;
    }

    public void setOpening(LocalDateTime opening) {
        this.opening = opening;
    }

    @Override
    public String toString() {
        return "PhysicalStore{" +
                "address='" + address + '\'' +
                ", size=" + size +
                ", terrace=" + terrace +
                ", opening=" + opening +
                '}';
    }
}
