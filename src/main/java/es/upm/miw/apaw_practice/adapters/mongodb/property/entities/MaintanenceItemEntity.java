package es.upm.miw.apaw_practice.adapters.mongodb.property.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class MaintanenceItemEntity {
    private String id;
    private String item;
    private String type;
    private LocalDate time;
    private BigDecimal fees;
    private Long invoice;
    private String equipment;
    private Boolean status;

    public MaintanenceItemEntity(){
        //empty from framework
    }

    public MaintanenceItemEntity(String id, String item, String type, LocalDate time, BigDecimal fees, Long invoice, String equipment, Boolean status) {
        this.id = id;
        this.item = item;
        this.type = type;
        this.time = time;
        this.fees = fees;
        this.invoice = invoice;
        this.equipment = equipment;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public Long getInvoice() {
        return invoice;
    }

    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MaintanenceItemEntity{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", fees=" + fees +
                ", invoice=" + invoice +
                ", equipment='" + equipment + '\'' +
                ", status=" + status +
                '}';
    }
}
