package backend.potsDraw;

import backend.basics.Country;
import backend.basics.Team;
import backend.comparators.TeamCoefficientComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Pot {
    private int potNumber;
    private ArrayList<Team> listOfTeamsInPot =new ArrayList<>();

    public Pot(){

    }

    public Pot(int potNumber){
        this.potNumber = potNumber;
    }

    public Pot(int potNumber, ArrayList<Team> listOfTeamsInPot) {
        this.potNumber = potNumber;
        this.listOfTeamsInPot = listOfTeamsInPot;
    }

    public int getPotNumber() {
        return potNumber;
    }

    public void setPotNumber(int potNumber) {
        this.potNumber = potNumber;
    }

    public ArrayList<Team> getListOfTeamsInPot() {
        return listOfTeamsInPot;
    }

    public void setListOfTeamsInPot(ArrayList<Team> listOfTeamsInPot) {
        this.listOfTeamsInPot = listOfTeamsInPot;
    }

    public void addTeamToPot(Team team){
        this.listOfTeamsInPot.add(team);
    }

    public Team getCertainTeamFromPot(int i){
        return listOfTeamsInPot.get(i-1);
    }

    public void setFirstPotOfTeams(ArrayList<Team> listOfTeams, HashMap<String, Country> listOfCountries){
        TeamCoefficientComparator tcc = new TeamCoefficientComparator();
        int rankingCapChange=0;
        for (Team t1 : listOfTeams) {
            if (listOfTeamsInPot.size()!=9){
                if (!listOfTeamsInPot.contains(t1)) {
                    if (t1.isUELChampion()) {
                        if (t1.isCountryChampion()&&t1.getTeamCountrysRanking(t1.getTeamCountry(),listOfCountries)<=7){
                            listOfTeamsInPot.add(t1);
                            ++rankingCapChange;
                        }else {
                            listOfTeamsInPot.add(t1);
                        }

                    }else if (t1.isUCLChampion()){
                        if (t1.isCountryChampion()&&t1.getTeamCountrysRanking(t1.getTeamCountry(),listOfCountries)<=7){
                            listOfTeamsInPot.add(t1);
                            ++rankingCapChange;
                        }else {
                            listOfTeamsInPot.add(t1);
                        }
                    }else if (t1.isCountryChampion()&&t1.getTeamCountrysRanking(t1.getTeamCountry(),listOfCountries)<=(7+rankingCapChange)){
                        listOfTeamsInPot.add(t1);
                    }
                }
            }
        }
        listOfTeamsInPot.sort(tcc);
    }

    public static ArrayList<Team> correctCountryCoefficients(ArrayList<Team> listOfTeams, HashMap<String, Country> listOfCountries){
        for (Team t1: listOfTeams) {
            int numberOfTeams=5;
            if (listOfCountries.get(t1.getTeamCountry()).getCountryRankingPosition()<=4){
//                numberOfTeams=5;
//            }else if(listOfCountries.get(t1.getTeamCountry()).getCountryRankingPosition()<=6){
//                numberOfTeams=5;
//            }else if(listOfCountries.get(t1.getTeamCountry()).getCountryRankingPosition()<=15){
//                numberOfTeams=5;
            }else if(listOfCountries.get(t1.getTeamCountry())==listOfCountries.get("Liechtenstein")){
                continue;
            }
//            else if(listOfCountries.get(t1.getTeamCountry()).getCountryRankingPosition()<=50){
//                numberOfTeams=5;
//            }
//            else {
//                numberOfTeams=5;
//            }
            if (listOfCountries.get(t1.getTeamCountry()).getCountryCoefficient()/numberOfTeams>t1.getTeamCoefficient()){
                t1.setTeamCoefficient(listOfCountries.get(t1.getTeamCountry()).getCountryCoefficient()/numberOfTeams);
            }

        }
        return listOfTeams;
    }


    public void setRemainingPots(ArrayList<Team> listOfTeams, HashMap<String, Country> listOfCountries){
        TeamCoefficientComparator tcc = new TeamCoefficientComparator();
        Random rand = new Random();
        correctCountryCoefficients(listOfTeams, listOfCountries);
        while (listOfTeamsInPot.size()!=27){
                int randomInt = rand.nextInt(listOfTeams.size());
                Team temp = listOfTeams.get(randomInt);
                if (!listOfTeamsInPot.contains(listOfTeams.get(randomInt))) {
                    if (temp.isUELChampion()) {
                        continue;
                    }else if (temp.isUCLChampion()){
                        continue;
                    }else if (temp.isCountryChampion()&&temp.getTeamCountrysRanking(temp.getTeamCountry(),listOfCountries)<=7){
                        continue;
                    }else{
                        listOfTeamsInPot.add(temp);
                    }
                }

        }
        listOfTeamsInPot.sort(tcc);

    }

    public void setRemainingPotsFixed(ArrayList<Team> listOfTeams, ArrayList<Team> allTeams){
        TeamCoefficientComparator tcc = new TeamCoefficientComparator();
        while (listOfTeamsInPot.size()!=27){
            for (Team t1: allTeams) {
                if (!listOfTeams.contains(t1)) {
                    listOfTeamsInPot.add(t1);
                }
            }

        }
        listOfTeamsInPot.sort(tcc);

    }

    public void setFullPotOfTeams(ArrayList<Team> listOfTeams){
        TeamCoefficientComparator tcc = new TeamCoefficientComparator();
        for (int i = 0 ; i < 9 ; ++i){
            int rand = new Random().nextInt(listOfTeams.size());
            if(listOfTeamsInPot.contains(listOfTeams.get(rand))){
                --i;
            }
            else{
                this.listOfTeamsInPot.add(listOfTeams.get(rand));
            }

        }
        listOfTeamsInPot.sort(tcc);
    }



    @Override
    public String toString() {
        return "Pot{" +
                "potNumber=" + potNumber +
                ", listOfTeamsInPot=" + listOfTeamsInPot +
                '}';
    }
}
