package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialListRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialPostRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialTrendRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialListEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialPostEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialTrendEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

@Service
public class SocialNetworkSeederService {

    @Autowired
    private SocialListRepository socialListRepository;
    @Autowired
    private SocialPostRepository socialPostRepository;
    @Autowired
    private SocialTrendRepository socialTrendRepository;
    @Autowired
    private SocialUserRepository socialUserRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- SocialNetwork Initial Load -----------");
        SocialPostEntity[] socialPostEntities = {
            new SocialPostEntity("Lorem ipsum dolor sit amet", 0, 0),
            new SocialPostEntity("Sed ut perspiciatis unde omnis", 1, 4),
            new SocialPostEntity("Li Europan lingues es membres", 4, 6),
            new SocialPostEntity("abc def ghi jkl mno", 3, 5)
        };
        this.socialPostRepository.saveAll(Arrays.asList(socialPostEntities));
        SocialTrendEntity[] socialTrendEntities = {
            new SocialTrendEntity("Europan", 1, socialPostEntities[2]),
            new SocialTrendEntity("abc", 2, socialPostEntities[3])
        };
        this.socialTrendRepository.saveAll(Arrays.asList(socialTrendEntities));
        SocialListEntity[] socialListEntities = {
            new SocialListEntity("Friends", "My friends", true),
            new SocialListEntity("Family", "My family members", true)
        };
        SocialUserEntity[] socialUserEntities = {
            new SocialUserEntity("Juan13", "Soy Juan13", false,
                    Arrays.asList(socialPostEntities[0], socialPostEntities[1]), Collections.singletonList(socialListEntities[1])),
            new SocialUserEntity("Famoso_oficial", "Cuenta Oficial", true,
                    Arrays.asList(socialPostEntities[2], socialPostEntities[3]), Collections.singletonList(socialListEntities[0])),
            new SocialUserEntity("Alicia97", "Bio de Alicia", false,
                    Collections.emptyList(), Collections.emptyList()),
        };
        socialListEntities[1].setSocialUserEntities(Collections.singletonList(socialUserEntities[2]));
        this.socialListRepository.saveAll(Arrays.asList(socialListEntities));
        this.socialUserRepository.saveAll(Arrays.asList(socialUserEntities));
    }

    public void deleteAll() {
        this.socialListRepository.deleteAll();
        this.socialPostRepository.deleteAll();
        this.socialTrendRepository.deleteAll();
        this.socialUserRepository.deleteAll();
    }

}
