package backend.backOfMain;

import backend.basics.Country;
import backend.basics.Matchday;
import backend.basics.Matchup;
import backend.basics.Team;
import backend.draw.OfficialDraw;
import backend.potsDraw.FullDraw;

import java.util.ArrayList;
import java.util.HashMap;

import static backend.basics.Country.readCountriesFromCsv;
import static backend.basics.Team.readTeamsFromCsv;

public class Start {
    static public void getDraw(String countriesSource, String teamsSource, String team){
        HashMap<String, Country> countriesList = readCountriesFromCsv(countriesSource);
        ArrayList<Team> teamsList = readTeamsFromCsv(teamsSource);

        FullDraw fd1 = new FullDraw();
        fd1.getFullDrawInPots(teamsList, countriesList);

        Matchday matchday1 = new Matchday(1);
        Matchday matchday2 = new Matchday(2);
        Matchday matchday3 = new Matchday(3);
        Matchday matchday4 = new Matchday(4);
        Matchday matchday5 = new Matchday(5);
        Matchday matchday6 = new Matchday(6);
        Matchday matchday7 = new Matchday(7);
        Matchday matchday8 = new Matchday(8);

        ArrayList<Matchday> matchdays1 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(1), fd1.getCertainPot(2));
        ArrayList<Matchday> matchdays6 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(3), fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays2 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(3), fd1.getCertainPot(1));
        ArrayList<Matchday> matchdays5 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(2), fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays3 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(1), fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays4 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(2), fd1.getCertainPot(3));
        ArrayList<Matchday> matchdays = new ArrayList<>();
        Matchday matchdayPot1 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(1));
        Matchday matchdayPot2 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(2));
        Matchday matchdayPot3 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(3));
        Matchday matchdayPot4 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(4));
        for (int i2 = 0; i2 < 2; ++i2) {
            matchdays.add(matchdays1.get(i2));
            matchdays.add(matchdays2.get(i2));
            matchdays.add(matchdays3.get(i2));
            matchdays.add(matchdays4.get(i2));
            matchdays.add(matchdays5.get(i2));
            matchdays.add(matchdays6.get(i2));
        }
        matchdays.add(matchdayPot1);
        matchdays.add(matchdayPot2);
        matchdays.add(matchdayPot3);
        matchdays.add(matchdayPot4);
        int k = 1;
        for (Matchday matchday : matchdays) {
            for (Matchup matchup : matchday.getMatchupsOnMatchday()) {
                if (matchup.getHomeTeam().getTeamName().equals(team) || matchup.getAwayTeam().getTeamName().equals(team)) {
                    System.out.println(k + ". " + matchup);
                    ++k;
//                    if (matchup.getHomeTeam().getTeamName().equals(team)){
//                        System.out.println(matchup.getAwayTeam().getTeamName());
//                    }else{
//                        System.out.println(matchup.getHomeTeam().getTeamName());
//                    }

                }
            }
        }
    }


}
