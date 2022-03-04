import java.util.*; 
import org.junit.*;
/**
 * Jake Irons
 * Country Database Test Class
 */
public class CountryTest
{
    public static void main(String args[]){
        CountryDatabase db = new CountryDatabase();

        // read the countries of the world file
        db.readCountriesData("Countries.csv");
        System.out.println("****Begin test***");

        // check number of records
        if(db.countAllCountries() != 195){
            System.out.println("Error: Number of countries should be 195");
        }

        // Testing population - countries with a population > 900 million
        ArrayList <Country> tempList1 = db.searchCountriesWithPopulation(900000000);
        if(tempList1.size() != 2){
            System.out.println("Error: it should be two countries with a " +
                "population greater than 900 million");
        }
        //Testing population - countries with a population > 0
        ArrayList <Country> tempList2 = db.searchCountriesWithPopulation(0);
        if(tempList2.size() != 195){
            System.out.println("Error: it should be 195 countries with a " +
                "population greater than 0");
        }

        //testing countries in continent - North America
        ArrayList <Country> tempList7 = db.searchCountriesInContinent("North America");
        if(tempList7.size() != 22){
            System.out.println("Error: there should be 22 countries in North America");
        }
        //testing countries in continent - North America
        ArrayList <Country> tempList8 = db.searchCountriesInContinent("South America");
        if(tempList8.size() != 13){
            System.out.println("Error: there should be 13 countries in South America");
        }

        //testing getting all countries
        ArrayList <Country> tempList9 = db.getAllCountries();
        if(tempList9.size() != 195){
            System.out.println("Error: it should be 195 countries");
        }

        //testing capital for country - United States
        String capital1 = db.searchForCapital("Japan");
        if(!capital1.equalsIgnoreCase("Imperial Tokyo")){
            System.out.println("Error: Capital of Japan is Imperial Tokyo");
        }
        String capital2 = db.searchForCapital("China");
        if(!capital2.equalsIgnoreCase("Beijing")){
            System.out.println("Error: Capital of China is Beijing");
        }

        //getting top 10 gdp - South America
        ArrayList <Country> tempList10 = db.topTenGdpCountries("South America");
        if(tempList10.size() != 10){
            System.out.println("Error: Did not give top 10 GDP countries");
        }

        //getting country with highest gdp - asia
        ArrayList <Country> tempList11 = db.searchCountriesInContinent("Asia");
        for(Country highest : tempList11){
            if(highest == db.highestGdp("Asia")){
                System.out.println(".");
            }
        }
        //testing for two different continents
        ArrayList <Country> tempList14 = db.searchCountriesInContinent("Europe");
        for(Country smallest : tempList14){
            if(smallest == db.smallestArea("Asia")){
                System.out.println("Error: the highest GDP in Asia should not also be found in Europe");
            }
        }

        //getting country with smallest area - Europe
        ArrayList <Country> tempList12 = db.searchCountriesInContinent("Europe");
        for(Country smallest : tempList12){
            if(smallest == db.smallestArea("Europe")){
                System.out.println(".");
            }
        }
        //testing for two different continents
        ArrayList <Country> tempList13 = db.searchCountriesInContinent("Europe");
        for(Country smallest : tempList13){
            if(smallest == db.smallestArea("Asia")){
                System.out.println("Error: the smallest country in Asia should not also be found in Europe");
            }
        }
        
        //finding country details - Canada
        ArrayList <Country> tempList15 = db.searchCountriesInContinent("North America");
        for(Country details : tempList15){
            if(details == db.findCountryDetails("Canada")){
                System.out.println(".");
            }
        }
        //testing for differing continent and country
        ArrayList <Country> tempList16 = db.searchCountriesInContinent("Europe");
        for(Country smallest : tempList16){
            if(smallest == db.smallestArea("Canada")){
                System.out.println("Error: details of Canada should not be found in Europe");
            }
        }

        System.out.println("*** Test complete***");
    }
}
