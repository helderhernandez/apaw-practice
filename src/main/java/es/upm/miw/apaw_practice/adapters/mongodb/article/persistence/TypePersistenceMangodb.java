package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.TypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.TypeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.article.Type;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.TypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypePersistenceMangodb implements TypePersistence {
    private final TypeRepository typeRepository;

    @Autowired
    public TypePersistenceMangodb(TypeRepository typeRepository){ this.typeRepository = typeRepository; }

    public void assertNameNotExist(String name) {
        this.typeRepository
                .findByName(name)
                .ifPresent(article ->{
                    throw new ConflictException("Name exist:" + name);
                });
    }

    @Override
    public Type create(Type type){
        this.assertNameNotExist(type.getName());
        return this.typeRepository
                .save(new TypeEntity(type))
                .toType1();
    }

    @Override
    public Type update(Type type){
        TypeEntity typeEntity = this.typeRepository
                .findById(type.getId())
                .orElseThrow(() -> new NotFoundException("Type id:" + type.getId()));
        typeEntity.fromType(type);
        return this.typeRepository
                .save(typeEntity)
                .toType1();
    }

    @Override
    public Type readByName(String name){
        return this.typeRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("type name" + name))
                .toType1();
    }
}
