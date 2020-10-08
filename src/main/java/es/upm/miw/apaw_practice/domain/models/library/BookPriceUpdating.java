package es.upm.miw.apaw_practice.domain.models.library;

import java.math.BigDecimal;

public class BookPriceUpdating {
    private String ISBN;
    private BigDecimal price;

    public BookPriceUpdating(String ISBN, BigDecimal price) {
        this.ISBN = ISBN;
        this.price = price;
    }

    public  BookPriceUpdating(){
        //empty from framework
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookPriceUpdating{" +
                "ISBN='" + ISBN + '\'' +
                ", price=" + price +
                '}';
    }
}
