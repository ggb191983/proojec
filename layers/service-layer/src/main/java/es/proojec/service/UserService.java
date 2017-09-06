package es.proojec.service;

import es.proojec.domain.entities.User;

/**
 * Created by ggb191983 on 06/09/2017.
 */
public interface UserService {
    User save(User entity);

    User find(Long id);

    Iterable<User> findAll();
}