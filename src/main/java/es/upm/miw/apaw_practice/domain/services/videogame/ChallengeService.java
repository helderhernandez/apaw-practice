package es.upm.miw.apaw_practice.domain.services.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.ChallengeDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.ChallengePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ChallengeService {

    private ChallengePersistence challengePersistence;

    @Autowired
    public ChallengeService(ChallengePersistence challengePersistence) {
        this.challengePersistence = challengePersistence;
    }

    public Stream<Challenge> readAll() {
        return challengePersistence.readAll();
    }

    public void updateDescription(List<ChallengeDescriptionUpdating> challengeDescriptionUpdatingList) {
        challengeDescriptionUpdatingList.stream()
                .map(challengeNewDescription -> {
                    Challenge challenge = this.challengePersistence.readById(challengeNewDescription.getId());
                    challenge.setDescription(challengeNewDescription.getDescription());
                    return challenge;
                }).forEach(challenge -> this.challengePersistence.update(challenge));
    }
}
