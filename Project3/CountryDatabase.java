import java.util.*; 
import java.text.*;
import java.io.*;
/**
 * Jake Irons
 * 
 */
public class CountryDatabase
{
    private ArrayList<Country> countryList;

    public CountryDatabase(){
        countryList = new ArrayList<Country>();
    }

    public void readCountriesData(String filename){

        // Read the full set of data from a text file
        try{
            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream(filename);
            Scanner scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");

            // keep reading as long as there is more data
            while(scnr.hasNext()) {
                // reading the fields from the record one at the time
                String name = scnr.next();
                String continent = scnr.next();
                int area = scnr.nextInt();
                int population = scnr.nextInt();
                double gdp = scnr.nextDouble();
                String capital = scnr.next();

                Country newCountry = new Country(name, continent, area, population, gdp, capital);

                countryList.add(newCountry);
            }
            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: " + filename);
        }

    }

    public int countAllCountries(){
        return countryList.size();   
    }

    public ArrayList<Country> getAllCountries(){
        return countryList;
    }

    public Country highestGdp(String continent){
        Country rtn = countryList.get(0);
        for(Country highest : countryList){
            if((highest.getContinent().equals(continent)) && (highest.getGDP() > rtn.getGDP())){
                rtn = highest;
            }
        }
        return rtn;
    }

    public Country smallestArea(String continent){
        Country rtn = countryList.get(0);
        for(Country smallest : countryList){
            if((smallest.getContinent().equals(continent)) && (smallest.getArea() < rtn.getArea())){
                rtn = smallest;
            }
        }
        return rtn;
    }

    public String searchForCapital(String countryName){
        String rtn = null;
        for(Country country : countryList){
            if(country.getCountry().equalsIgnoreCase(countryName)){
                rtn = country.getCapital();
            }
        }
        return rtn;
    }

    public Country findCountryDetails(String countryName){
        Country rtn = null;
        for(Country details : countryList){
            if(details.getCountry().equalsIgnoreCase(countryName)){
                rtn = details;
            }
        }
        return rtn;
    }

    public ArrayList <Country> searchCountriesInContinent(String continent){
        ArrayList<Country> tempList = new ArrayList<Country>();
        for(Country homeContinent : countryList){
            if(homeContinent.getContinent().equals(continent)){
                tempList.add(homeContinent);
            }
        }
        Collections.sort(tempList);
        return tempList;
    }

    public ArrayList <Country> searchCountriesWithPopulation(int population){
        ArrayList<Country> tempList = new ArrayList<Country>();
        for(Country greaterPop : countryList){
            if(greaterPop.getPopulation() > population){
                tempList.add(greaterPop);
            }
        }
        return tempList;
    }

    public ArrayList <Country> topTenGdpCountries(String continent){
        ArrayList<Country> tempList1 = new ArrayList<Country>();
        tempList1 = searchCountriesInContinent(continent);
        ArrayList<Country> tempList2 = new ArrayList<Country>(tempList1.subList(0, 10));
        return tempList2;
    }
}
