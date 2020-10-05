package es.upm.miw.apaw_practice.adapters.rest.shop;

import es.upm.miw.apaw_practice.domain.models.shop.Article;

public class BasicArticleDto {
    private String id;
    private Long barcode;

    public BasicArticleDto() {
        // empty for framework
    }

    BasicArticleDto(Article article) {
        this.id = article.getId();
        this.barcode = article.getBarcode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "BasicArticleDto{" +
                "id='" + id + '\'' +
                ", barcode=" + barcode +
                '}';
    }
}
