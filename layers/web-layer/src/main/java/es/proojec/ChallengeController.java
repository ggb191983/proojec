package es.proojec;

import com.google.common.collect.Lists;
import es.proojec.domain.models.ChallengeDTO;
import es.proojec.service.ChallengeServiceImpl;
import es.proojec.store.entities.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ChallengeController extends AbstractController<ChallengeServiceImpl, ChallengeDTO, Challenge, Serializable> {

    @Autowired
    protected ChallengeController(final ChallengeServiceImpl managerClass) {
        super(managerClass, ChallengeDTO.class, Challenge.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/challenge/{id}")
    ResponseEntity<ChallengeDTO> home(@PathVariable Long id) {
        Challenge p = getManager().find(id);
        if (p == null) {
            return null;
        }
        return new ResponseEntity<>(super.convertToDto(p), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/challenge")
    public ResponseEntity<Collection<ChallengeDTO>> getAllChallenges() {
        Iterable<Challenge> challenges = getManager().findAll();
        return new ResponseEntity<>(super.convertToDto(Lists.newArrayList(challenges)), HttpStatus.FOUND);
    }

}
