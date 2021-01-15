package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities;

import java.util.List;

public interface TattoistBuilder {

    interface id {
        Name id(String id);
    }

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals email(String email);
        Optionals nickname(String nickname);
        Optionals phone(String phone);
        Optionals mainStyle(String mainStyle);
        Optionals ranking(float ranking);
        Optionals consumers(List<ConsumerEntity> consumerEntities);
        TattoistEntity build();
    }
}
