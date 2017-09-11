package es.proojec.service;

import es.proojec.store.entities.Label;
import es.proojec.store.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@Service
public class LabelServiceImpl extends AbstractManager<LabelRepository, Label, Long> implements LabelService {

    @Autowired
    protected LabelServiceImpl(LabelRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Label save(Label entity) {
        return repository.save(entity);
    }

    @Override
    public Label find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Label> findAll() {
        return repository.findAll();
    }
}
