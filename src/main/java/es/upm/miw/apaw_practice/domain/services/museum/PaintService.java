package es.upm.miw.apaw_practice.domain.services.museum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaintService {

    private PaintPersistence paintPersistence;

    @Autowired
    public PaintService( PaintPersistence paintPersistence){
        this.paintPersistence = paintPersistence;
    }
}
