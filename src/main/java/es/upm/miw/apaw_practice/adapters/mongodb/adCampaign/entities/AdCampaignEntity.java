package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.PromotionEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Document
public class AdCampaignEntity {
    @Id
    private String id;
    private LocalDateTime scheduleDate;
    private Integer success;
    private Integer error;
    private String status;
    @DBRef
    private LikesEntity likesEntity;
    @DBRef
    private List<PromotionEntity> promotionEntities;

    public AdCampaignEntity() {
    }

    public AdCampaignEntity(String id, LocalDateTime scheduleDate, LikesEntity likesEntity, List<PromotionEntity> promotionEntities) {
        this.id = id;
        this.scheduleDate = scheduleDate;
        this.likesEntity = likesEntity;
        this.promotionEntities = promotionEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDateTime scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LikesEntity getLikesEntity() {
        return likesEntity;
    }

    public void setLikesEntity(LikesEntity likesEntity) {
        this.likesEntity = likesEntity;
    }

    public List<PromotionEntity> getPromotionEntities() {
        return promotionEntities;
    }

    public void setPromotionEntities(List<PromotionEntity> promotionEntities) {
        this.promotionEntities = promotionEntities;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id='" + id + '\'' +
                ", scheduleDate=" + scheduleDate +
                ", success=" + success +
                ", error=" + error +
                ", status='" + status + '\'' +
                '}';
    }
}
