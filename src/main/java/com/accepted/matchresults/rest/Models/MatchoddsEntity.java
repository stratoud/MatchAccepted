package com.accepted.matchresults.rest.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "matchodds", schema = "public", catalog = "MatchResults")
public class MatchoddsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "match_id")
    private int matchId;
    @Basic
    @Column(name = "specifier")
    private String specifier;
    @Basic
    @Column(name = "odd")
    private BigDecimal odd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchoddsEntity that = (MatchoddsEntity) o;
        return id == that.id && matchId == that.matchId && Objects.equals(specifier, that.specifier) && Objects.equals(odd, that.odd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matchId, specifier, odd);
    }
}
