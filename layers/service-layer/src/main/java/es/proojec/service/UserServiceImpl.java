package es.proojec.service;

import es.proojec.store.entities.User;
import es.proojec.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Service
public class UserServiceImpl extends AbstractManager<UserRepository, User, Long> implements UserService {

    @Autowired
    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
