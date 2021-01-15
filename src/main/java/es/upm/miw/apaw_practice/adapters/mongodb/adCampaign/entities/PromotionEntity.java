package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PromotionEntity {
    @Id
    private String id;
    private String title;
    private String header;
    private String description;

    public PromotionEntity() {
    }

    public static PromotionEntityBuilder.Id builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Promotion toPromotion() {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(this, promotion);
        return promotion;
    }

    public void fromArticle(Promotion promotion) {
        BeanUtils.copyProperties(promotion, this);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder implements PromotionEntityBuilder.Id, PromotionEntityBuilder.Title, PromotionEntityBuilder.Header, PromotionEntityBuilder.Description, PromotionEntityBuilder.Build {
        public PromotionEntity promotionEntity;

        public Builder() {
            this.promotionEntity = new PromotionEntity();
        }

        @Override
        public PromotionEntityBuilder.Title id(String id) {
            this.promotionEntity.id = id;
            return this;
        }

        @Override
        public PromotionEntityBuilder.Header title(String title) {
            this.promotionEntity.title = title;
            return this;
        }

        @Override
        public PromotionEntityBuilder.Description header(String header) {
            this.promotionEntity.header = header;
            return this;
        }

        @Override
        public PromotionEntityBuilder.Build description(String description) {
            this.promotionEntity.description = description;
            return this;
        }

        @Override
        public PromotionEntity build() {
            return this.promotionEntity;
        }
    }
}
