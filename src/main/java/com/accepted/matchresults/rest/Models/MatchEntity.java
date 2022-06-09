package com.accepted.matchresults.rest.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "match", schema = "public", catalog = "MatchResults")
public class MatchEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "match_date")
    private Date matchDate;
    @Basic
    @Column(name = "match_time")
    private Time matchTime;
    @Basic
    @Column(name = "team_a")
    private String teamA;
    @Basic
    @Column(name = "team_b")
    private String teamB;
    @Basic
    @Column(name = "sport")
    private int sport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Time getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Time matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchEntity that = (MatchEntity) o;
        return id == that.id && Objects.equals(teamA, that.teamA) && Objects.equals(teamB, that.teamB) && sport == that.sport && Objects.equals(description, that.description) && Objects.equals(matchDate, that.matchDate) && Objects.equals(matchTime, that.matchTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, matchDate, matchTime, teamA, teamB, sport);
    }
}
