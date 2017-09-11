package es.proojec.service;

import es.proojec.store.entities.Challenge;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public interface ChallengeService {
    Challenge save(Challenge entity);

    Challenge find(Long id);

    Iterable<Challenge> findAll();
}
