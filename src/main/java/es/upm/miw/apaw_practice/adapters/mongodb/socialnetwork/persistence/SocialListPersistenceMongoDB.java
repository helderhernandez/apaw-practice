package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialListRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialListPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository("socialListPersistence")
public class SocialListPersistenceMongoDB implements SocialListPersistence {

    private SocialListRepository socialListRepository;

    @Autowired
    public SocialListPersistenceMongoDB(SocialListRepository socialListRepository) {
        this.socialListRepository = socialListRepository;
    }

    @Override
    public void deleteById(String id) {
        this.socialListRepository.deleteById(id);
    }

    @Override
    public Set<String> findVerifiedNickNamesByListName(String listName) {
        return this.socialListRepository.findAll().stream()
                .filter(socialListEntity -> socialListEntity.getName().equals(listName))
                .flatMap(socialListEntity -> socialListEntity.getSocialUserEntities().stream())
                .filter(SocialUserEntity::isVerified)
                .map(SocialUserEntity::getNickName)
                .collect(Collectors.toSet());
    }

}
