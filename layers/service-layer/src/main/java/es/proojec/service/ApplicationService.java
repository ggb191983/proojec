package es.proojec.service;

import es.proojec.store.entities.Application;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public interface ApplicationService {
    Application save(Application entity);

    Application find(Long id);

    Iterable<Application> findAll();
}
