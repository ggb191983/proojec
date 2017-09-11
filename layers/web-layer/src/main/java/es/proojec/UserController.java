package es.proojec;

import es.proojec.domain.models.UserDTO;
import es.proojec.service.UserServiceImpl;
import es.proojec.store.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    ResponseEntity<UserDTO> home() {
        User p = getManager().findAll().iterator().next();
        return new ResponseEntity<>(super.convertToDto(p), HttpStatus.FOUND);
    }

  //  @ApiImplicitParams({
   //         @ApiImplicitParam(name = "Authorization",
   //                 value = "Bearer access_token",
   //                 required = true,
   //                 dataType = "string",
   //                 paramType = "header"),
   // })
    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    ResponseEntity<UserDTO> signup() {
        User p = getManager().findAll().iterator().next();
        return new ResponseEntity<>(super.convertToDto(p), HttpStatus.FOUND);
    }
}