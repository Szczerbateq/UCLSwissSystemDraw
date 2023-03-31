package main;

import backend.basics.Country;
import backend.basics.Matchday;
import backend.basics.Matchup;
import backend.basics.Team;
import backend.draw.OfficialDraw;
import backend.potsDraw.FullDraw;
import backend.potsDraw.Pot;

import java.util.*;

import static backend.basics.Country.readCountriesFromCsv;
import static backend.basics.Team.readTeamsFromCsv;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Country> countriesList = readCountriesFromCsv("resources/CountriesRanking.csv");
        ArrayList<Team> teamsList = readTeamsFromCsv("resources/testing.csv");

        Pot pot1 = new Pot(1);
        Pot pot2 = new Pot(2);

//        pot1.setFullPotOfTeams(teamsList);
//        for (Team t1: pot1.getListOfTeamsInPot()) {
//            System.out.println(t1);
//        }
//        pot1.setFirstPotOfTeams(teamsList,countriesList);
//        for (Team t1: pot1.getListOfTeamsInPot()) {
//            System.out.println(t1);
//        }
//        int i =1;
//        pot2.setRemainingPots(teamsList,countriesList);
//        for (Team t1: pot2.getListOfTeamsInPot()) {
//            System.out.println(i);
//            System.out.println(t1);
//            i++;
//        }

        FullDraw fd1 = new FullDraw();
        fd1.getFullDrawInPotsFixed(teamsList,countriesList);
//        int k = 1;
//        for (Pot p1: fd1.getListOfPotsInFullDraw()) {
//            System.out.println("Koszyk numer " + k);
//            ++k;
//            for (Team t1: p1.getListOfTeamsInPot()) {
//                System.out.println(t1);
//            }
//
//        }

        Matchday matchday1 = new Matchday(1);
        Matchday matchday2 = new Matchday(2);
        Matchday matchday3 = new Matchday(3);
        Matchday matchday4 = new Matchday(4);
        Matchday matchday5 = new Matchday(5);
        Matchday matchday6 = new Matchday(6);
        Matchday matchday7 = new Matchday(7);
        Matchday matchday8 = new Matchday(8);


        Integer[] intArray1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> intList1 = Arrays.asList(intArray1);
        Collections.shuffle(intList1);
        intList1.toArray(intArray1);

//        Integer[] intArray2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        List<Integer> intList2 = Arrays.asList(intArray2);
//        Collections.shuffle(intList2);
//        intList2.toArray(intArray2);
//        int i1=0;
//        while (matchday1.getMatchupsOnMatchday() == null||matchday1.getMatchupsOnMatchday().size()<9) {
//            for (Team t1 : fd1.getCertainPot(1).getListOfTeamsInPot()) {
//                if (matchday1.getMatchupsOnMatchday()==null){
//                    Team t2 = fd1.getCertainPot(2).getListOfTeamsInPot().get(intArray1[i1]);
//                    matchday1.setMatchupsOnMatchday(new ArrayList<Matchup>());
//                    matchday1.addMatchupToMatchday(new Matchup(t1, t2));
//                }else{
//                    Team t2 = fd1.getCertainPot(2).getListOfTeamsInPot().get(intArray1[i1]);
//                    matchday1.addMatchupToMatchday(new Matchup(t1, t2));
//                }
//
//                ++i1;
//            }
//            System.out.println(matchday1);


//        }

//        for (Matchup m1: matchday1.getMatchupsOnMatchday()) {
//            System.out.println(m1.toString());
//
//        }
        OfficialDraw od1 = new OfficialDraw();
//        od1.doTheDraw(fd1);
//        for (Matchday matchday: od1.getListOfMatchdays()) {
//            System.out.println(matchday);
//
//        }
        ArrayList<Matchday> matchdays1 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(1),fd1.getCertainPot(2));
        ArrayList<Matchday> matchdays2 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(3),fd1.getCertainPot(1));
        ArrayList<Matchday> matchdays3 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(1),fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays4 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(2),fd1.getCertainPot(3));
        ArrayList<Matchday> matchdays5 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(2),fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays6 = OfficialDraw.drawTwoMatchdaysBetweenTwoDifferentPots(fd1.getCertainPot(3),fd1.getCertainPot(4));
        ArrayList<Matchday> matchdays = new ArrayList<>();
        Matchday matchdayPot1 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(1));
        Matchday matchdayPot2 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(2));
        Matchday matchdayPot3 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(3));
        Matchday matchdayPot4 = OfficialDraw.drawMatchupsInsideOnePot(fd1.getCertainPot(4));
        for (int i2=0;i2<2;++i2){
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
        int k=1;
        for (Matchday matchday: matchdays) {
            for (Matchup matchup: matchday.getMatchupsOnMatchday()) {
                if (matchup.getHomeTeam().getTeamName().equals("Arsenal FC")||matchup.getAwayTeam().getTeamName().equals("Arsenal FC"))
                System.out.println(k+". " + matchup);
                ++k;
            }

        }

    }
}
