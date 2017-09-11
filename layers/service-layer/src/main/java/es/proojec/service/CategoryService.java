package es.proojec.service;

import es.proojec.store.entities.Category;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public interface CategoryService  {
    Category save(Category entity);

    Category find(Long id);

    Iterable<Category> findAll();
}
