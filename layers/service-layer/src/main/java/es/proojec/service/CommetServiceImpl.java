package es.proojec.service;

import es.proojec.store.entities.Comment;
import es.proojec.store.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public class CommetServiceImpl extends AbstractManager<CommentRepository, Comment, Long> implements CommentService {

    @Autowired
    protected CommetServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Comment save(Comment entity) {
        return repository.save(entity);
    }

    @Override
    public Comment find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return repository.findAll();
    }
}
