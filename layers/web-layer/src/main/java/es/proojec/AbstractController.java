package es.proojec;

import es.proojec.domain.models.ObjectDTO;
import es.proojec.service.AbstractManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public abstract class AbstractController<M extends AbstractManager, O extends ObjectDTO, E extends Serializable, ID extends Serializable> {
    private M manager;

    private Class<O> dtoClass;

    private Class<E> entityClass;

    @Autowired
    private ModelMapper modelMapper;

    protected AbstractController(final M managerClass, final Class<O> dtoClass, final Class<E> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.manager = managerClass;
    }

    protected O convertToDto(final E entity) {
        return this.convertFromInstanceToClass(entity, dtoClass);
    }

    protected E convertToEntity(final O dto) {
        return this.convertFromInstanceToClass(dto, entityClass);
    }

    protected <C extends Object> C convertFromInstanceToClass(final Object fromObjectInstance, final Class<C> toClass) {
        return modelMapper.map(fromObjectInstance, toClass);
    }

    protected Collection<O> convertToDto(final Collection<E> entityCollection) {
        return entityCollection.stream()
                .map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }

    protected Collection<E> convertToEntity(final Collection<O> dtoList) {
        return dtoList.stream()
                .map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    protected M getManager() {
        return manager;
    }


}
