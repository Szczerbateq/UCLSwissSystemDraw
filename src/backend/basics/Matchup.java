package backend.basics;

import java.util.Objects;

public class Matchup {
    private Team homeTeam;
    private Team awayTeam;

    public Matchup(){

    }

    public Matchup(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matchup)) return false;
        Matchup matchup = (Matchup) o;
        return (homeTeam.equals(matchup.homeTeam) && awayTeam.equals(matchup.awayTeam))||(homeTeam.equals(matchup.awayTeam) && awayTeam.equals(matchup.homeTeam));
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public String toString() {
        return  homeTeam.getTeamName()  +" vs "+ awayTeam.getTeamName();
    }
}
