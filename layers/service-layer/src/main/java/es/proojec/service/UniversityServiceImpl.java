package es.proojec.service;

import es.proojec.store.entities.University;
import es.proojec.store.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public class UniversityServiceImpl extends AbstractManager<UniversityRepository, University, Long> implements UniversityService {

    @Autowired
    protected UniversityServiceImpl(UniversityRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public University save(University entity) {
        return repository.save(entity);
    }

    @Override
    public University find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<University> findAll() {
        return repository.findAll();
    }
}
