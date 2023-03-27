package main;

import backend.basics.Country;
import backend.basics.Team;
import backend.draw.Pot;

import java.util.HashMap;

import static backend.basics.Country.readCountriesFromCsv;
import static backend.basics.Team.readTeamsFromCsv;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Country> CountriesMap = readCountriesFromCsv("resources/CountriesRanking.csv");
        HashMap<String, Team> TeamsMap = readTeamsFromCsv("resources/ClubsRanking.csv");

//        System.out.println(CountriesMap.get(TeamsMap.get("Lech Poznań").getTeamCountry()).getCountryName());

        Pot pot1 = new Pot(1);
//        for (int i = 0 ; i < 9 ; i++){
//            pot1.addTeamToPot();
//        }
        pot1.addTeamToPot(TeamsMap.get("Lech Poznań"));
        System.out.println(pot1);
    }
}
