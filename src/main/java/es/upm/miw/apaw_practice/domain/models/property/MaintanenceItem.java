package es.upm.miw.apaw_practice.domain.models.property;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MaintanenceItem {

    private String item;
    private String type;
    private LocalDate time;
    private BigDecimal fees;
    private Long invoice;
    private String equipment;
    private Boolean status;

    public MaintanenceItem(){
        //empty from framework
    }

    public MaintanenceItem(String item) {
        this.item = item;
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
        return "MaintanenceItem{" +
                "item='" + item + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", fees=" + fees +
                ", invoice=" + invoice +
                ", equipment='" + equipment + '\'' +
                ", status=" + status +
                '}';
    }
}