package backend.draw;

import backend.basics.Team;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Pot{" +
                "potNumber=" + potNumber +
                ", listOfTeamsInPot=" + listOfTeamsInPot +
                '}';
    }
}
