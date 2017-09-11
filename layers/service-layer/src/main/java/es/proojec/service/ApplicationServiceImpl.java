package es.proojec.service;

import es.proojec.store.entities.Application;
import es.proojec.store.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@Service
public class ApplicationServiceImpl extends AbstractManager<ApplicationRepository, Application, Long> implements ApplicationService {

    protected ApplicationServiceImpl(ApplicationRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Application save(Application entity) {
        return repository.save(entity);
    }

    @Override
    public Application find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Application> findAll() {
        return repository.findAll();
    }
}
