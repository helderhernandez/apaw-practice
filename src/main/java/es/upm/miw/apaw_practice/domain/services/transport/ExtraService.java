package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.ExtraPaidUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.ExtraPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ExtraService {

    private ExtraPersistence extraPersistence;

    @Autowired
    public ExtraService(ExtraPersistence extraPersistence) {
        this.extraPersistence = extraPersistence;
    }

    public void updatePaid(List<ExtraPaidUpdate> extraPaidUpdates) {
        extraPaidUpdates.stream()
                .map(extraNewPaid -> {
                    Extra extra = this.extraPersistence.findById(extraNewPaid.getId());
                    extra.setPaid(extraNewPaid.isPaid());
                    return extra;
                })
                .forEach(extra -> this.extraPersistence.update(extra));
    }

    public Stream<Extra> readAll() {
        return this.extraPersistence.readAll();
    }

    public void delete(String id) {
        this.extraPersistence.deleteById(id);
    }
}
