package backend.draw;

import backend.basics.Matchday;
import backend.basics.Matchup;
import backend.basics.Team;
import backend.potsDraw.FullDraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OfficialDraw {
    private ArrayList<Matchday> listOfMatchdays;
    private ArrayList<Matchup> listOfMatchups;


    public OfficialDraw(){

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

    static public Integer[] getNumbersFrom0To8InRandomOrder(){
        Integer[] intArray1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> intList1 = Arrays.asList(intArray1);
        Collections.shuffle(intList1);
        return intList1.toArray(intArray1);
    }
    static public Integer[] getRulesOfMatchdays(int i){
        Integer[] array;
        switch (i){
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


    public void doTheDraw(FullDraw fd1){
        listOfMatchups = new ArrayList<>();
        listOfMatchdays = new ArrayList<>();
        Integer[] intArray1 = getNumbersFrom0To8InRandomOrder();
        for(int i=0;i<6;++i) {
            int i1 = 0;
            Matchday matchday = new Matchday(i + 1, new ArrayList<>());
            while (matchday.getMatchupsOnMatchday() == null || matchday.getMatchupsOnMatchday().size()!=9) {
                for (Team t1 : fd1.getCertainPot(getRulesOfMatchdays(i)[0]).getListOfTeamsInPot()) {
                    if (matchday.getMatchupsOnMatchday()==null){
                        Team t2 = fd1.getCertainPot(getRulesOfMatchdays(i)[1]).getListOfTeamsInPot().get(intArray1[i1]);
                        Matchup m1 = new Matchup(t1,t2);
                        if (listOfMatchups.size()==0){
                            matchday.setMatchupsOnMatchday(new ArrayList<Matchup>());
                            matchday.addMatchupToMatchday(new Matchup(t1, t2));
                            listOfMatchups.add(new Matchup(t1,t2));
                        }else{
                            for (Matchup matchup: listOfMatchups) {
                                if (!matchup.equals(m1)){
                                    matchday.addMatchupToMatchday(new Matchup(t1, t2));
                                    listOfMatchups.add(new Matchup(t1,t2));
                                    ++i1;
                                }
                            }
                        }


                    }else{
                        Team t2 = fd1.getCertainPot(getRulesOfMatchdays(i)[1]).getListOfTeamsInPot().get(intArray1[i1]);
                        Matchup m1 = new Matchup(t1,t2);
                        for (Matchup matchup: listOfMatchups) {
                            if (!matchup.equals(m1)){
                                matchday.addMatchupToMatchday(new Matchup(t1, t2));
                                ++i1;
                            }
                        }
                    }
                }
            }
            i1=0;
            while (matchday.getMatchupsOnMatchday().size()!=18)
            {for (Team t1 : fd1.getCertainPot(getRulesOfMatchdays(i)[2]).getListOfTeamsInPot()) {
                if (matchday.getMatchupsOnMatchday()==null){
                    Team t2 = fd1.getCertainPot(getRulesOfMatchdays(i)[3]).getListOfTeamsInPot().get(intArray1[i1]);
                    Matchup m1 = new Matchup(t1,t2);
                    if (listOfMatchups.size()==0){
                        matchday.setMatchupsOnMatchday(new ArrayList<Matchup>());
                        matchday.addMatchupToMatchday(new Matchup(t1, t2));
                        listOfMatchups.add(new Matchup(t1,t2));
                    }else{
                        for (Matchup matchup: listOfMatchups) {
                            if (!matchup.equals(m1)){
                                matchday.addMatchupToMatchday(new Matchup(t1, t2));
                                listOfMatchups.add(new Matchup(t1,t2));
                                ++i1;
                            }
                        }
                    }


                }else{
                    Team t2 = fd1.getCertainPot(getRulesOfMatchdays(i)[3]).getListOfTeamsInPot().get(intArray1[i1]);
                    Matchup m1 = new Matchup(t1,t2);
                    for (Matchup matchup: listOfMatchups) {
                        if (!matchup.equals(m1)){
                            matchday.addMatchupToMatchday(new Matchup(t1, t2));
                            ++i1;
                        }
                    }
                }
            }
            }
            listOfMatchdays.add(matchday);
        }
    }


    @Override
    public String toString() {
        return "OfficialDraw{" +
                "listOfMatchdays=" + listOfMatchdays +
                '}';
    }
}
