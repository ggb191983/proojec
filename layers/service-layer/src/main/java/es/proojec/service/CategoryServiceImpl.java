package es.proojec.service;

import com.google.common.collect.Lists;
import es.proojec.store.entities.Category;
import es.proojec.store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@Service
public class CategoryServiceImpl extends AbstractManager<CategoryRepository, Category, Long> implements CategoryService {

    @Autowired
    protected CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Category save(Category entity) {
        return repository.save(entity);
    }

    @Override
    public Category find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return Lists.newArrayList(repository.findAll());
    }
}
