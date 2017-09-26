package es.proojec;

import es.proojec.domain.models.UserDTO;
import es.proojec.service.UserServiceImpl;
import es.proojec.store.entities.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class UserController extends AbstractController<UserServiceImpl, UserDTO, User, Serializable> {

    protected UserController(final UserServiceImpl managerClass) {
        super(managerClass, UserDTO.class, User.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public UserDTO getUser(@RequestParam("nick") String nick) {
        User p = getManager().findByEmail(nick);
        return super.convertToDto(p);
    }

  //  @ApiImplicitParams({
   //         @ApiImplicitParam(name = "Authorization",
   //                 value = "Bearer access_token",
   //                 required = true,
   //                 dataType = "string",
   //                 paramType = "header"),
   // })
    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    @ResponseBody
    UserDTO signup() {
        User p = getManager().findAll().iterator().next();
        return super.convertToDto(p);
    }
}