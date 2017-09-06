package es.proojec;

import es.proojec.service.UserService;
import es.proojec.store.UserRepository;
import es.proojec.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@RestController
public class HomeController {

    @Autowired
    protected UserService userService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        User p = userService.findAll().iterator().next();
        return "Hello " + p.getName() + "!";
    }
}
