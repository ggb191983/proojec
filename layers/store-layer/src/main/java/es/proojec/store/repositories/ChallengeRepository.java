package es.proojec.store.repositories;

import es.proojec.store.entities.Challenge;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ggb191983 on 08/09/2017.
 */
@Repository
public interface ChallengeRepository extends PagingAndSortingRepository<Challenge, Long> {
}
