package es.proojec;

import com.google.common.collect.Lists;
import es.proojec.domain.models.ApplicationDTO;
import es.proojec.service.ApplicationServiceImpl;
import es.proojec.store.entities.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ApplicationController extends AbstractController<ApplicationServiceImpl, ApplicationDTO, Application, Serializable> {

    @Autowired
    protected ApplicationController(final ApplicationServiceImpl managerClass) {
        super(managerClass, ApplicationDTO.class, Application.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/application/{id}")
    ResponseEntity<ApplicationDTO> home(@PathVariable Long id) {
        Application p = getManager().find(id);
        if (p == null) {
            return null;
        }
        return new ResponseEntity<>(super.convertToDto(p), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/application")
    public ResponseEntity<Collection<ApplicationDTO>> getAllApplications() {
        Iterable<Application> applications = getManager().findAll();
        return new ResponseEntity<>(super.convertToDto(Lists.newArrayList(applications)), HttpStatus.FOUND);
    }

}
