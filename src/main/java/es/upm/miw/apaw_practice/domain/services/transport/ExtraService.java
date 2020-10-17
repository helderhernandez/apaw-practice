package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.ExtraPaidUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.ExtraPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.WorkerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ExtraService {

    private final ExtraPersistence extraPersistence;
    private final WorkerPersistence workerPersistence;

    @Autowired
    public ExtraService(ExtraPersistence extraPersistence, WorkerPersistence workerPersistence) {
        this.extraPersistence = extraPersistence;
        this.workerPersistence = workerPersistence;
    }

    public void updatePaid(List<ExtraPaidUpdate> extraPaidUpdates) {
        extraPaidUpdates.stream()
                .map(extraNewPaid -> {
                    Extra extra = this.extraPersistence.findById(extraNewPaid.getId());
                    extra.setPaid(extraNewPaid.isPaid());
                    return extra;
                })
                .forEach(this.extraPersistence::update);
    }

    public Stream<Extra> readAll() {
        return this.extraPersistence.readAll();
    }

    public void delete(String id) {
        this.extraPersistence.deleteById(id);
    }

    public Stream<Integer> readWorkedHoursByDepartment(String name) {
        List<String> listofWorkers = this.workerPersistence.findByDepartmentName(name);
        return this.extraPersistence.readWorkedHoursByWorker(listofWorkers);
    }
}
