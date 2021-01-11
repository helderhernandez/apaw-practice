package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.AdCampaign;

import java.time.LocalDateTime;

public class BasicAdCampaignDto {
    private String id;
    private LocalDateTime scheduleDate;

    public BasicAdCampaignDto() {
        //empty by framework
    }

    public BasicAdCampaignDto(AdCampaign adCampaign) {
        this.id = adCampaign.getId();
        this.scheduleDate = adCampaign.getScheduleDate();
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

    @Override
    public String toString() {
        return "BasicAdCampaignDto{" +
                "id='" + id + '\'' +
                ", scheduleDate=" + scheduleDate +
                '}';
    }
}
