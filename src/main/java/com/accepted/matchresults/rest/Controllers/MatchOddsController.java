package com.accepted.matchresults.rest.Controllers;

import com.accepted.matchresults.rest.Models.MatchEntity;
import com.accepted.matchresults.rest.Models.MatchoddsEntity;
import com.accepted.matchresults.rest.Repo.MatchOddsRepository;
import com.accepted.matchresults.rest.Repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matchOddsAPI")
public class MatchOddsController {

    @Autowired
    private MatchOddsRepository matchOddsRepo;

    @GetMapping(value = "/allMatchOdds")
    public List<MatchoddsEntity> getMatches(){
        System.out.println("getMatches");
        return matchOddsRepo.findAll();
    }

    @GetMapping(value = "/matchOdds/{id}")
    public Optional<MatchoddsEntity> getMatchById(@PathVariable long id){
        System.out.println("getMatches by Id");
        return matchOddsRepo.findById((long) id);
    }

    @PostMapping(value = "/createMatchOdds")
    public long createMatchOdds(@RequestBody MatchoddsEntity matchOdds){
        System.out.println("create Match");
        matchOdds.setMatchId(matchOdds.getMatchId());
        matchOdds.setSpecifier(matchOdds.getSpecifier());
        matchOdds.setOdd(matchOdds.getOdd());
        MatchoddsEntity ent = matchOddsRepo.save(matchOdds);
        return ent.getId();
    }

    @PutMapping(value = "/updateMatchOdds/{id}")
    public void updateMatchOdds(@PathVariable long id, @RequestBody MatchoddsEntity matchOdds){
        System.out.println("update Match");
        MatchoddsEntity oldMatchOdds = matchOddsRepo.findById(id).get();
        oldMatchOdds.setMatchId(matchOdds.getMatchId());
        oldMatchOdds.setSpecifier(matchOdds.getSpecifier());
        oldMatchOdds.setOdd(matchOdds.getOdd());
        MatchoddsEntity ent = matchOddsRepo.save(oldMatchOdds);
    }

    @DeleteMapping(value = "/deleteMatchOdds/{id}")
    public void deleteMatchOdds(@PathVariable int id){
        System.out.println("delete Match");
        matchOddsRepo.deleteById((long) id);
    }
}
