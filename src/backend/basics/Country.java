package backend.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Country {
    private String countryName;
    private float countryCoefficient;
    private int countryRankingPosition;

    public Country() {

    }

    public Country(String countryName, float countryCoefficient, int countryRankingPosition) {
        this.countryName = countryName;
        this.countryCoefficient = countryCoefficient;
        this.countryRankingPosition = countryRankingPosition;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getCountryCoefficient() {
        return countryCoefficient;
    }

    public void setCountryCoefficient(float countryCoefficient) {
        this.countryCoefficient = countryCoefficient;
    }

    public int getCountryRankingPosition() {
        return countryRankingPosition;
    }

    public void setCountryRankingPosition(int countryRankingPosition) {
        this.countryRankingPosition = countryRankingPosition;
    }

    public static Country addCountryFromLineInFile(String[] data) {
        String cName = data[0];
        float cCoefficient = Float.parseFloat(data[1]);
        int cRankingPosition = Integer.parseInt(data[2]);
        return new Country(cName,cCoefficient,cRankingPosition);
    }

    public static HashMap<String, Country> readCountriesFromCsv(String fileName){
        HashMap<String, Country> countries = new HashMap<>();
        Path filePath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(filePath)){
            String line = br.readLine();

            while (line!=null){
                line = line.replace(",",".");
                String[] elements = line.split(";");
                Country country = addCountryFromLineInFile(elements);
                countries.put(elements[0],country);
                line=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryCoefficient=" + countryCoefficient +
                ", countryRankingPosition=" + countryRankingPosition +
                '}';
    }


}
