package es.proojec;

import com.google.common.collect.Lists;
import es.proojec.domain.models.ApplicationDTO;
import es.proojec.service.ApplicationServiceImpl;
import es.proojec.store.entities.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
    @ResponseBody
    ApplicationDTO home(@PathVariable Long id) {
        Application p = getManager().find(id);
        return super.convertToDto(p);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/application")
    @ResponseBody
    public Collection<ApplicationDTO> getAllApplications() {
        List<Application> applications = Lists.newArrayList(getManager().findAll());
        return super.convertToDto(applications);
    }

}
