package es.proojec.service;

import es.proojec.store.entities.University;

/**
 * Created by ggb191983 on 06/09/2017.
 */
public interface UniversityService {
    University save(University entity);

    University find(Long id);

    Iterable<University> findAll();
}
