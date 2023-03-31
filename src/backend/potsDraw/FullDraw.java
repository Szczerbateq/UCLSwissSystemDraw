package backend.potsDraw;

import backend.basics.Country;
import backend.basics.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class FullDraw {
    private ArrayList<Pot> listOfPotsInFullDraw;

    public FullDraw() {

    }

    public FullDraw(ArrayList<Pot> listOfPotsInFullDraw) {
        this.listOfPotsInFullDraw = listOfPotsInFullDraw;

    }

    public ArrayList<Pot> getListOfPotsInFullDraw() {
        return listOfPotsInFullDraw;
    }

    public Pot getCertainPot(int i ) {
        return listOfPotsInFullDraw.get(i-1);
    }


    public void setListOfPotsInFullDraw(ArrayList<Pot> listOfPotsInFullDraw) {
        this.listOfPotsInFullDraw = listOfPotsInFullDraw;
    }

    public void getFullDrawInPots(ArrayList<Team> listOfTeams, HashMap<String, Country> listOfCountries) {
        Pot pot1 = new Pot(1);
        pot1.setFirstPotOfTeams(listOfTeams, listOfCountries);
        Pot potX = new Pot(100);
        potX.setRemainingPots(listOfTeams, listOfCountries);
        Pot pot2 = new Pot(2);
        Pot pot3 = new Pot(3);
        Pot pot4 = new Pot(4);
        for (int i = 0; i < potX.getListOfTeamsInPot().size(); ++i) {
            if (i < 9) {
                pot2.addTeamToPot(potX.getListOfTeamsInPot().get(i));
            } else if (i < 18) {
                pot3.addTeamToPot(potX.getListOfTeamsInPot().get(i));
            } else if (i < 27) {
                pot4.addTeamToPot(potX.getListOfTeamsInPot().get(i));
            }
        }
        ArrayList<Pot> finalDraw = new ArrayList<>();
        finalDraw.add(pot1);
        finalDraw.add(pot2);
        finalDraw.add(pot3);
        finalDraw.add(pot4);
        setListOfPotsInFullDraw(finalDraw);
    }


    @Override
    public String toString() {
        return "FullDraw{" +
                "listOfPotsInFullDraw=" + listOfPotsInFullDraw +
                '}';
    }
}
