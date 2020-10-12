package es.upm.miw.apaw_practice.domain.services.music;


import es.upm.miw.apaw_practice.domain.models.music.Style;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.StylePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    private final StylePersistence stylePersistence;

        @Autowired
        public StyleService(StylePersistence stylePersistence){
            this.stylePersistence = stylePersistence;
        }

        public Style create(Style style){
             return this.stylePersistence.create(style);
        }
}

