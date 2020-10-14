package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.services.basketball.MemberTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(MemberTeamResource.MEMBERSTEAMS)
public class MemberTeamResource {

    static final String MEMBERSTEAMS = "/basketball/membersteam";

    private MemberTeamService memberTeamService;

    @Autowired
    public MemberTeamResource(MemberTeamService memberTeamService) {
        this.memberTeamService = memberTeamService;
    }

    @GetMapping
    public Stream<MemberTeamDto> readAll() {
        return this.memberTeamService.readAll().map(MemberTeamDto::new);
    }
}
