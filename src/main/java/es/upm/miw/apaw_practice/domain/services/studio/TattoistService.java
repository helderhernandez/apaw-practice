package es.upm.miw.apaw_practice.domain.services.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.TattoistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TattoistService {

    private TattoistPersistence tattoistPersistence;

    @Autowired
    public TattoistService(TattoistPersistence tattoistPersistence) {
        this.tattoistPersistence = tattoistPersistence;
    }

    public Stream<Tattoist> readAll() {
        return this.tattoistPersistence.readAll();
    }

}
