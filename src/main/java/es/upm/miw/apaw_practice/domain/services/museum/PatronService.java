package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PatronPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PatronService {
    private PatronPersistence patronPersistence;

    @Autowired
    public PatronService(PatronPersistence patronPersistence){ this.patronPersistence = patronPersistence;}

    public Stream<String>findPatronsIDByArtistName(String artistName){
       return this.patronPersistence.findPatronsIDByArtistName(artistName);
    }
}
