package es.upm.miw.apaw_practice.domain.models.adCampaign;

import java.time.LocalDateTime;

public class AdCampaign {
    private String id;
    private LocalDateTime scheduleDate;
    private Integer success;
    private Integer error;
    private String status;

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

    @Override
    public String toString() {
        return "AdCampaign{" +
                "id='" + id + '\'' +
                ", scheduleDate=" + scheduleDate +
                ", success=" + success +
                ", error=" + error +
                ", status='" + status + '\'' +
                '}';
    }
}
