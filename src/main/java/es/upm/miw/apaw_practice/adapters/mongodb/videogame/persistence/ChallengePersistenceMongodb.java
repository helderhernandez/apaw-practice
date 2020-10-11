package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.ChallengeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.ChallengeEntity;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.ChallengePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.util.stream.Stream;

@Repository("challengePersistence")
public class ChallengePersistenceMongodb implements ChallengePersistence {

    private ChallengeRepository challengeRepository;

    @Autowired
    public ChallengePersistenceMongodb(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public Stream<Challenge> readAll() {
        return challengeRepository.findAll().stream()
                .map(ChallengeEntity::toChallenge);
    }

    @Override
    public Challenge readById(String id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Challenge id: " + id))
                .toChallenge();
    }

    @Override
    public Challenge update(Challenge challenge) {
        ChallengeEntity challengeEntity = this.challengeRepository.findById(challenge.getId())
                .orElseThrow(() -> new NotFoundException("Challenge id: " + challenge.getId()));
        challengeEntity.fromChallenge(challenge);
        return this.challengeRepository
                .save(challengeEntity)
                .toChallenge();
    }
}
