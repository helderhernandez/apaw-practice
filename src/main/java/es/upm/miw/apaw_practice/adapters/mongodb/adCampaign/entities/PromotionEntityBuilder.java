package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities;

public interface PromotionEntityBuilder {
    interface Id {
        Title id(String id);
    }

    interface Title {
        Header title(String title);
    }

    interface Header {
        Description header(String header);
    }

    interface Description {

        Build description(String description);
    }

    interface Build {
        PromotionEntity build();
    }
}
