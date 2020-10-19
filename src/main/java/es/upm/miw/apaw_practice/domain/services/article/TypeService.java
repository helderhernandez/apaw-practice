package es.upm.miw.apaw_practice.domain.services.article;

import es.upm.miw.apaw_practice.domain.models.article.Type;
import es.upm.miw.apaw_practice.domain.models.article.TypeDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.TypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypePersistence typePersistence;

    @Autowired
    public TypeService(TypePersistence typePersistence) { this.typePersistence = typePersistence; }

    public Type creat(Type type) { return this.typePersistence.create(type); }

    public void updateDescription(List<TypeDescriptionUpdating> typeDescriptionUpdatingList){
        typeDescriptionUpdatingList.stream()
                .map(typeNewDescripton ->{
                    Type type = this.typePersistence.readByName(typeNewDescripton.getName());
                    return type;
                })
                .forEach(type -> this.typePersistence.update(type));
    }
}
