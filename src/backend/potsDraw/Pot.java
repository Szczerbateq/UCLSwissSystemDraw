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
        for (Team t1 : listOfTeams) {
            if (listOfTeamsInPot.size()!=9){
                if (!listOfTeamsInPot.contains(t1)) {
                    if (t1.isUELChampion()) {
                        listOfTeamsInPot.add(t1);
                    }else if (t1.isUCLChampion()){
                        listOfTeamsInPot.add(t1);
                    }else if (t1.isCountryChampion()&&t1.getTeamCountrysRanking(t1.getTeamCountry(),listOfCountries)<=7){
                        listOfTeamsInPot.add(t1);
                    }
                }
            }
        }
        listOfTeamsInPot.sort(tcc);
    }

    public void setRemainingPots(ArrayList<Team> listOfTeams, HashMap<String, Country> listOfCountries){
        TeamCoefficientComparator tcc = new TeamCoefficientComparator();
        Random rand = new Random();
        int i =0;
        while (listOfTeamsInPot.size()!=27){
            i++;
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
