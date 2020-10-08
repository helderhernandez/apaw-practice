package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.padel.Tournament;
import es.upm.miw.apaw_practice.domain.services.padel.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping(TournamentResource.TOURNAMENT)
public class TournamentResource {
    static final String TOURNAMENT = "/padel/tournaments";
    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";
    static final String START_DAY = "/start-day";

    private TournamentService tournamentService;

    @Autowired
    public TournamentResource(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PutMapping
    public Tournament updateStartDay(@PathVariable String id,@RequestBody LocalDateTime startDay){
        return this.tournamentService.uptadeStartDay(id,startDay);
    }

    @GetMapping(SEARCH)
    public Stream<NameTournamentDto> findByTournamentsAndNameDistintOfPlayer(@RequestParam String q){
        String name = new LexicalAnalyzer().extractWithAssure(q,"name");
        return this.tournamentService.findByTournamentsAndNameDistintOfPlayer(name)
                .map(NameTournamentDto::new);
    }
}
