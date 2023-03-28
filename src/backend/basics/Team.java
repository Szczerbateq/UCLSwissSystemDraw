package backend.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private String teamName;
    private String teamCountry;
    private float teamCoefficient;
    private boolean isCountryChampion;
    private boolean isUCLChampion;
    private boolean isUELChampion;

    public Team(){

    }

    public Team(String teamName, String teamCountry, float teamCoefficient, boolean isCountryChampion,
                boolean isUCLChampion, boolean isUELChampion) {
        this.teamName = teamName;
        this.teamCoefficient = teamCoefficient;
        this.teamCountry = teamCountry;
        this.isCountryChampion = isCountryChampion;
        this.isUCLChampion = isUCLChampion;
        this.isUELChampion = isUELChampion;
    }
    public Team(String teamName, float teamCoefficient, String teamCountry) {
        this.teamName = teamName;
        this.teamCoefficient = teamCoefficient;
        this.teamCountry = teamCountry;
        this.isCountryChampion = false;
        this.isUCLChampion = false;
        this.isUELChampion = false;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public float getTeamCoefficient() {
        return teamCoefficient;
    }

    public void setTeamCoefficient(float teamCoefficient) {
        this.teamCoefficient = teamCoefficient;
    }

    public String getTeamCountry() {
        return teamCountry;
    }

    public void setTeamCountry(String teamCountry) {
        this.teamCountry = teamCountry;
    }

    public boolean isCountryChampion() {
        return isCountryChampion;
    }

    public void setCountryChampion(boolean countryChampion) {
        isCountryChampion = countryChampion;
    }

    public boolean isUCLChampion() {
        return isUCLChampion;
    }

    public void setUCLChampion(boolean UCLChampion) {
        isUCLChampion = UCLChampion;
    }

    public boolean isUELChampion() {
        return isUELChampion;
    }

    public void setUELChampion(boolean UELChampion) {
        isUELChampion = UELChampion;
    }

    public static Team addTeamFromLineInFile(String[] data) {
        String tName = data[0];
        String tCountry = data[1];
        float tCoefficient = Float.parseFloat(data[2]);
        boolean tLeagueChamp = Boolean.parseBoolean(data[3]);
        boolean tUCLChamp = Boolean.parseBoolean(data[4]);
        boolean tELChamp = Boolean.parseBoolean(data[5]);
        return new Team(tName,tCountry,tCoefficient,tLeagueChamp,tUCLChamp,tELChamp);
    }

    public Country getTeamCountry(String countryName, HashMap<String, Country> countriesList){
        return countriesList.get(countryName);
    }

    public int getTeamCountrysRanking(String countryName, HashMap<String, Country> countriesList){
        return countriesList.get(countryName).getCountryRankingPosition();
    }

    public static ArrayList<Team> readTeamsFromCsv(String fileName){
        ArrayList<Team> countries = new ArrayList<>();
        Path filePath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(filePath)){
            String line = br.readLine();
            line = line.replace(",",".");

            while (line!=null){

                line = line.replace(",",".");
                String[] elements = line.split(";");
                Team team = addTeamFromLineInFile(elements);
                countries.add(team);
                line=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }




    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamCoefficient=" + teamCoefficient +
                ", teamCountry=" + teamCountry +
                ", isCountryChampion=" + isCountryChampion +
                ", isUCLChampion=" + isUCLChampion +
                ", isUELChampion=" + isUELChampion +
                '}';
    }


    public static void main(String[] args) {
        ArrayList<Team> test1 = readTeamsFromCsv("resources/ClubsRanking.csv");
        for (Team t: test1) {
            System.out.println(t);
        }
    }
}
