package com.accepted.matchresults.rest.Controllers;

import com.accepted.matchresults.rest.Models.MatchEntity;
import com.accepted.matchresults.rest.Repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/allMatches")
    public List<MatchEntity> getMatches(){
        System.out.println("getMatches print ");
        return matchRepo.findAll();
    }

    @GetMapping(value = "/match/{id}")
    public Optional<MatchEntity> getMatchById(@PathVariable long id){
        System.out.println("getMatches print ");
        return matchRepo.findById(id);
    }

    @PostMapping(value = "/createMatch")
    public long createMatch(@RequestBody MatchEntity match){
        System.out.println("create Match");
        match.setMatchDate(match.getMatchDate());
        match.setMatchTime(match.getMatchTime());
        match.setTeamA(match.getTeamA());
        match.setTeamB(match.getTeamB());
        match.setSport(match.getSport());
        match.setDescription(match.getTeamA() + " - " + match.getTeamB());
        MatchEntity ent = matchRepo.save(match);
        return ent.getId();
    }

    @PutMapping(value = "/updateMatch/{id}")
    public String updateMatch(@PathVariable long id, @RequestBody MatchEntity match){
        MatchEntity oldMatch = matchRepo.findById((long) id).get();
        System.out.println("update Match");
        oldMatch.setMatchDate(match.getMatchDate());
        oldMatch.setMatchTime(match.getMatchTime());
        oldMatch.setTeamA(match.getTeamA());
        oldMatch.setTeamB(match.getTeamB());
        oldMatch.setSport(match.getSport());
        oldMatch.setDescription(match.getTeamA() + " - " + match.getTeamB());
        MatchEntity ent = matchRepo.save(oldMatch);
        return "Updated";
    }

    @DeleteMapping(value = "/deleteMatch/{id}")
    public void deleteMatch(@PathVariable long id){
        System.out.println("delete Match");
        matchRepo.deleteById(id);
    }
}
