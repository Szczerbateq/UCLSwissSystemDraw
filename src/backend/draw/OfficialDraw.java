package backend.draw;

import backend.basics.Matchday;
import backend.basics.Matchup;
import backend.basics.Team;
import backend.potsDraw.FullDraw;
import backend.potsDraw.Pot;

import java.util.*;

public class OfficialDraw {
    private ArrayList<Matchday> listOfMatchdays;
    private ArrayList<Matchup> listOfMatchups;


    public OfficialDraw() {

    }

    public OfficialDraw(ArrayList<Matchday> listOfMatchdays) {
        this.listOfMatchdays = listOfMatchdays;
    }

    public ArrayList<Matchday> getListOfMatchdays() {
        return listOfMatchdays;
    }

    public void setListOfMatchdays(ArrayList<Matchday> listOfMatchdays) {
        this.listOfMatchdays = listOfMatchdays;
    }

    public ArrayList<Matchup> getListOfMatchups() {
        return listOfMatchups;
    }

    public void setListOfMatchups(ArrayList<Matchup> listOfMatchups) {
        this.listOfMatchups = listOfMatchups;
    }

    static public Integer[] getNumbersFrom0To8InRandomOrder() {
        Integer[] intArray1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> intList1 = Arrays.asList(intArray1);
        Collections.shuffle(intList1);
        return intList1.toArray(intArray1);
    }

    static public Integer[] getRulesOfMatchdays(int i) {
        Integer[] array;
        switch (i) {
            case 0:
                return array = new Integer[]{2, 1, 3, 4};
            case 1:
                return array = new Integer[]{2, 3, 4, 1};
            case 2:
                return array = new Integer[]{3, 1, 4, 2};
            case 3:
                return array = new Integer[]{3, 2, 1, 4};
            case 4:
                return array = new Integer[]{1, 3, 2, 4};
            case 5:
                return array = new Integer[]{1, 2, 4, 3};

        }
        return null;
    }

    static public ArrayList<Matchday> drawTwoMatchdaysBetweenTwoDifferentPots(Pot p1, Pot p2) {
        ArrayList<Matchday> matchdays = new ArrayList<>();
        Matchday matchday1 = new Matchday(1, new ArrayList<>());
        Matchday matchday2 = new Matchday(1, new ArrayList<>());
        int k = 10;
        while (k != 0) {
            matchday1 = new Matchday(1, new ArrayList<>());
            k = 0;
            int i = 10;
            Integer[] listOfRandomValues1 = null;
            while (i != 0) {
                i = 0;
                Integer[] firstRandomValues = getNumbersFrom0To8InRandomOrder();
                Integer[] secondRandomValues = getNumbersFrom0To8InRandomOrder();
                for (int j = 0; j < 9; ++j) {
                    if (Objects.equals(firstRandomValues[j], secondRandomValues[j])) {
                        ++i;
                    }
                }
                listOfRandomValues1 = firstRandomValues;
            }
            int j = 0;
            for (Team t1 : p1.getListOfTeamsInPot()) {
                Team t2 = p2.getListOfTeamsInPot().get(listOfRandomValues1[j]);
                matchday1.addMatchupToMatchday(new Matchup(t1, t2));
                ++j;
            }
            for (Matchup matchup1 : matchday1.getMatchupsOnMatchday()) {
                if (matchup1.getAwayTeam().getTeamCountry().equals(matchup1.getHomeTeam().getTeamCountry())) {
                    k++;
                }
            }
        }
        int l = 10;
        while (l != 0) {
            matchday2 = new Matchday(1, new ArrayList<>());
            l = 0;
            int i = 10;
            Integer[] listOfRandomValues2 = null;
            while (i != 0) {
                i = 0;
                Integer[] firstRandomValues = getNumbersFrom0To8InRandomOrder();
                Integer[] secondRandomValues = getNumbersFrom0To8InRandomOrder();
                for (int j = 0; j < 9; ++j) {
                    if (Objects.equals(firstRandomValues[j], secondRandomValues[j])) {
                        ++i;
                    }
                }
                listOfRandomValues2 = secondRandomValues;
            }
            int j = 0;
            for (Team t1 : p1.getListOfTeamsInPot()) {
                Team t3 = p2.getListOfTeamsInPot().get(listOfRandomValues2[j]);
                Matchup nextMatchup = new Matchup(t3, t1);
                for (Matchup matchup1 : matchday1.getMatchupsOnMatchday()) {
                    if (matchup1.equals(nextMatchup)) {
                        l++;
                    }
                }
                matchday2.addMatchupToMatchday(new Matchup(t3, t1));
                ++j;
            }
            for (Matchup matchup1 : matchday2.getMatchupsOnMatchday()) {
                if (matchup1.getAwayTeam().getTeamCountry().equals(matchup1.getHomeTeam().getTeamCountry())) {
                    l++;
                }
            }

        }

        matchdays.add(matchday1);
        matchdays.add(matchday2);
        return matchdays;
    }

    static public Matchday drawMatchupsInsideOnePot(Pot p1) {
        Matchday matchday1 = new Matchday(1, new ArrayList<>());
        int k = 10;
        while (k != 0) {
            k = 0;
            matchday1 = new Matchday(1, new ArrayList<>());
            int i = 10;
            Integer[] listOfRandomValues1 = null;
            Integer[] listOfRandomValues2 = null;
            while (i != 0) {
                i = 0;
                Integer[] firstRandomValues = getNumbersFrom0To8InRandomOrder();
                Integer[] secondRandomValues = getNumbersFrom0To8InRandomOrder();
                for (int j = 0; j < 9; ++j) {
                    Integer firstRandVal = firstRandomValues[j];
                    Integer secondRandVal = secondRandomValues[j];

                    if (Objects.equals(firstRandVal, secondRandVal)) {
                        ++i;break;
                    }
                }
                listOfRandomValues1 = firstRandomValues;
                listOfRandomValues2 = secondRandomValues;
            }
            for (int j = 0; j < 9; ++j) {
                matchday1.addMatchupToMatchday(new Matchup(p1.getCertainTeamFromPot(listOfRandomValues1[j] + 1), p1.getCertainTeamFromPot(listOfRandomValues2[j] + 1)));
            }
            ArrayList<Matchup> listOfRepeatingClubs = new ArrayList<>();
            for (Matchup matchup1 : matchday1.getMatchupsOnMatchday()) {
                if (matchup1.getAwayTeam().getTeamCountry().equals(matchup1.getHomeTeam().getTeamCountry())) {
                    k++;
                }
                if (listOfRepeatingClubs.isEmpty()){
                    listOfRepeatingClubs.add(new Matchup(matchup1.getAwayTeam(),matchup1.getHomeTeam()));
                }else {
                    if (listOfRepeatingClubs.contains(new Matchup(matchup1.getAwayTeam(),matchup1.getHomeTeam()))){
                        k++;break;
                    }else{
                        listOfRepeatingClubs.add(new Matchup(matchup1.getAwayTeam(),matchup1.getHomeTeam()));
                    }
                }

            }
        }

        return matchday1;
    }

    public void doTheDraw(FullDraw fd1) {

        drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(1), fd1.getCertainPot(2));
    }


    @Override
    public String toString() {
        return "OfficialDraw{" +
                "listOfMatchdays=" + listOfMatchdays +
                '}';
    }
}
