package es.proojec.service;

import es.proojec.store.entities.Challenge;
import es.proojec.store.repositories.ChallengeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@Service
public class ChallengeServiceImpl extends AbstractManager<ChallengeRepository, Challenge, Long> implements ChallengeService {

    protected ChallengeServiceImpl(ChallengeRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Challenge save(Challenge entity) {
        return repository.save(entity);
    }

    @Override
    public Challenge find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Challenge> findAll() {
        return repository.findAll();
    }
}
