package es.proojec;

import com.google.common.collect.Lists;
import es.proojec.domain.models.ChallengeDTO;
import es.proojec.service.ChallengeServiceImpl;
import es.proojec.store.entities.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
    @ResponseBody
    public ChallengeDTO getChallenge(@PathVariable Long id) {
        Challenge p = getManager().find(id);
        return super.convertToDto(p);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/challenge")
    @ResponseBody
    public Collection<ChallengeDTO> getAllChallenges() {
        List<Challenge> challenges = Lists.newArrayList(getManager().findAll());
        return super.convertToDto(challenges);
    }

}
