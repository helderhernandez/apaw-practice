package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class OrderEntity {
    @Id
    private String id;
    private BigDecimal rental;
    private LocalDateTime creationTime;
    private LocalDateTime paymentTime;
    private LocalDateTime returnTime;

    @DBRef
    private BookEntity bookEntity;
    private ReaderEntity readerEntity;

    public  OrderEntity(){
        //empty for framework
    }
    public OrderEntity(String id, BigDecimal rental, LocalDateTime creationTime, LocalDateTime paymentTime, LocalDateTime returnTime, BookEntity bookEntity, ReaderEntity readerEntity) {
        this.id = id;
        this.rental = rental;
        this.creationTime = creationTime;
        this.paymentTime = paymentTime;
        this.returnTime = returnTime;
        this.bookEntity = bookEntity;
        this.readerEntity = readerEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getRental() {
        return rental;
    }

    public void setRental(BigDecimal rental) {
        this.rental = rental;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public ReaderEntity getReaderEntity() {
        return readerEntity;
    }

    public void setReaderEntity(ReaderEntity readerEntity) {
        this.readerEntity = readerEntity;
    }

    public Order toOrder(){
        Order order=new Order();
        BeanUtils.copyProperties(this, order);
        return order;
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((OrderEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", rental=" + rental +
                ", creationTime=" + creationTime +
                ", paymentTime=" + paymentTime +
                ", returnTime=" + returnTime +
                ", bookEntity=" + bookEntity +
                ", readerEntity=" + readerEntity +
                '}';
    }
}
