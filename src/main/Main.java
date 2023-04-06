package main;

import backend.backOfMain.Start;

public class Main {
    public static void main(String[] args) {
//        for (int i = 0 ; i < 100 ; ++i){
//            Start.getDraw("resources/CountriesRanking.csv","resources/testing.csv", "FC Barcelona");
//        }
        Start.getMultipleDrawsForTeam("resources/CountriesRanking.csv","resources/testing.csv", "FC Barcelona",2);

    }
}
