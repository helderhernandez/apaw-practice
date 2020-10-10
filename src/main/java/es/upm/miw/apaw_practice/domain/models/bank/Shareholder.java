package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Shareholder {
    private String id;
    private BigDecimal percentage;
    private BigDecimal value;
    private LocalDateTime expirationDate;
    private Boolean active;

    public Shareholder() {
        //Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Shareholder{" +
                "id='" + id + '\'' +
                ", percentage=" + percentage +
                ", value=" + value +
                ", expirationDate=" + expirationDate +
                ", isActive=" + active +
                '}';
    }
}
