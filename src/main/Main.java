package main;

import backend.basics.Country;
import backend.basics.Team;
import backend.draw.Pot;

import java.util.ArrayList;
import java.util.HashMap;

import static backend.basics.Country.readCountriesFromCsv;
import static backend.basics.Team.readTeamsFromCsv;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Country> countriesList = readCountriesFromCsv("resources/CountriesRanking.csv");
        ArrayList<Team> teamsList = readTeamsFromCsv("resources/ClubsRanking.csv");

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
        int i =1;
        pot2.setRemainingPots(teamsList,countriesList);
        for (Team t1: pot2.getListOfTeamsInPot()) {
            System.out.println(i);
            System.out.println(t1);
            i++;
        }

    }
}
