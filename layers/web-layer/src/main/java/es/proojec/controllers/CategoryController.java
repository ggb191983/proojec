package es.proojec.controllers;

import com.google.common.collect.Lists;
import es.proojec.domain.models.CategoryDTO;
import es.proojec.service.CategoryServiceImpl;
import es.proojec.store.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by ggb191983 on 13/09/2017.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController extends AbstractController<CategoryServiceImpl, CategoryDTO, Category, Serializable> {

    @Autowired
    protected CategoryController(final CategoryServiceImpl managerClass) {
        super(managerClass, CategoryDTO.class, Category.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    Collection<CategoryDTO> getCategories() {
        List<Category> categories = Lists.newArrayList(getManager().findAll());
        return super.convertToDto(categories);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public CategoryDTO getCategory(@PathVariable Long id) {
        Category category = getManager().find(id);
        return super.convertToDto(category);
    }

}