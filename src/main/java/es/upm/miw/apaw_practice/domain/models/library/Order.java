package es.upm.miw.apaw_practice.domain.models.library;


import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.ReaderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private String id;
    private BigDecimal rental;
    private LocalDateTime creationTime;
    private LocalDateTime paymentTime;
    private LocalDateTime returnTime;
    private BookEntity book;
    private ReaderEntity reader;

    public Order() {
        //empty from framework
    }

    public Order(String id, BigDecimal rental, LocalDateTime creationTime, LocalDateTime paymentTime, LocalDateTime returnTime, BookEntity book, ReaderEntity reader) {
        this.id = id;
        this.rental = rental;
        this.creationTime = creationTime;
        this.paymentTime = paymentTime;
        this.returnTime = returnTime;
        this.book = book;
        this.reader = reader;
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

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public ReaderEntity getReader() {
        return reader;
    }

    public void setReader(ReaderEntity reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", rental=" + rental +
                ", creationTime=" + creationTime +
                ", paymentTime=" + paymentTime +
                ", returnTime=" + returnTime +
                ", book=" + book +
                ", reader=" + reader +
                '}';
    }
}
