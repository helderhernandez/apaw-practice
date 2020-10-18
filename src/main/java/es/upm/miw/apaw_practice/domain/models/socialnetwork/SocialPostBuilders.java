package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.time.LocalDateTime;

public interface SocialPostBuilders {

    interface Id {
        PostingDate id(String id);
    }

    interface PostingDate {
        Content postingDate(LocalDateTime postingDate);
    }

    interface Content {
        Shared content(String content);
    }

    interface Shared {
        Likes shared(Integer shared);
    }

    interface Likes {
        Optionals likes(Integer likes);
    }

    interface Optionals {
        SocialPost build();
    }

}
