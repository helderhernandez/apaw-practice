package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.OwnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.OwnerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Owner;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.OwnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("OwnerPersistence")
public class OwnerPersistenceMongodb implements OwnerPersistence {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerPersistenceMongodb(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void deleteById(String id) {
        this.ownerRepository.deleteById(id);
    }

    @Override
    public Owner create(Owner owner) {
        this.assertDniNoExist(owner.getDni());
        return this.ownerRepository.save(new OwnerEntity(owner)).toOwner();
    }

    private void assertDniNoExist(String dni) {
        this.ownerRepository.findByDni(dni)
                .ifPresent(ownerEntity -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }
}
