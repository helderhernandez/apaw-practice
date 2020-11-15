package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PaintPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaintService {

    private PaintPersistence paintPersistence;

    @Autowired
    public PaintService( PaintPersistence paintPersistence){
        this.paintPersistence = paintPersistence;
    }

    public Paint create (Paint paint){
        return this.paintPersistence.create(paint);
    }
}
