package es.proojec.controllers;

import com.google.common.collect.Lists;
import es.proojec.domain.models.ChallengeDTO;
import es.proojec.service.ChallengeServiceImpl;
import es.proojec.store.entities.Challenge;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "challenges", description = "Challenges API", produces = "application/json")
public class ChallengeController extends AbstractController<ChallengeServiceImpl, ChallengeDTO, Challenge, Serializable> {

    @Autowired
    protected ChallengeController(final ChallengeServiceImpl managerClass) {
        super(managerClass, ChallengeDTO.class, Challenge.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/challenge/{id}")
    @ApiOperation(value = "Get the challenge resource.", notes = "Returns the URL of the new resource in the Location header.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of challenge detail", response = ChallengeDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 404, message = "ChallengeDTO with given id does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
        }
    )
    public ChallengeDTO getChallenge(@PathVariable Long id) {
        Challenge p = getManager().find(id);
        return super.convertToDto(p);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/challenge")
    @ApiOperation(value = "Get a challenge collection of all challenges.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Collection<ChallengeDTO> getAllChallenges() {
        List<Challenge> challenges = Lists.newArrayList(getManager().findAll());
        return super.convertToDto(challenges);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/challenge")
    @ApiOperation(value = "Create a challenge resource.", notes = "Returns the URL of the new resource in the Location header.")
    public ChallengeDTO saveChallenge(@RequestBody ChallengeDTO challengeDTO) {
        Challenge challenge = super.convertToEntity(challengeDTO);
        return super.convertToDto(getManager().save(challenge));
    }
}
