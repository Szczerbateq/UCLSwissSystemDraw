package backend.basics;

import java.util.ArrayList;

public class Matchday {


    private int matchdayNumber;
    private ArrayList<Matchup> matchupsOnMatchday;

    public Matchday() {

    }

    public Matchday(int matchdayNumber) {
        this.matchdayNumber = matchdayNumber;
    }
    public Matchday(int matchdayNumber, ArrayList<Matchup> matchupsOnMatchday) {
        this.matchdayNumber = matchdayNumber;
        this.matchupsOnMatchday=matchupsOnMatchday;
    }

    public int getMatchdayNumber() {
        return matchdayNumber;
    }

    public void setMatchdayNumber(int matchdayNumber) {
        this.matchdayNumber = matchdayNumber;
    }

    public ArrayList<Matchup> getMatchupsOnMatchday() {
        return matchupsOnMatchday;
    }

    public void setMatchupsOnMatchday(ArrayList<Matchup> matchupsOnMatchday) {
        this.matchupsOnMatchday=matchupsOnMatchday;
    }

    public Matchup getCertainMatchupFromMatchday(int i){
        return matchupsOnMatchday.get(i-1);
    }

    public void addMatchupToMatchday(Matchup matchup){
        matchupsOnMatchday.add(matchup);
    }

    @Override
    public String toString() {
        return "Matchday{" +
                "matchdayNumber=" + matchdayNumber +
                ", matchupsOnMatchday=" + matchupsOnMatchday +
                '}';
    }
}
