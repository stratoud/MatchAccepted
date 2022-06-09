package com.accepted.matchresults.rest.Repo;

import com.accepted.matchresults.rest.Models.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {



}
