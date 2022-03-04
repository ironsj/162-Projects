import java.util.*; 
import java.text.*;
/**
 * Jake Irons
 * Project 4
 */
public class Country implements Comparable{
    private String ctryName;
    private String ctryContinent;
    private int ctryArea;
    private int ctryPopulation;
    private double ctryGDP;
    private String ctryCapital;

    public Country(){
        ctryName  = "United States";
        ctryContinent = "North America";
        ctryCapital = "Washington D.C.";
    }

    public Country(String name, String continent, int area, int population, double gdp, String capital){
        ctryName = name;
        ctryContinent = continent;
        ctryArea = area;
        ctryPopulation = population;
        ctryGDP = gdp;
        ctryCapital = capital;
    }

    public String getCountry(){
        return ctryName;    
    }

    public String getContinent(){
        return ctryContinent;   
    }

    public int getArea(){
        return ctryArea;   
    }

    public int getPopulation(){
        return ctryPopulation;   
    }

    public double getGDP(){
        return ctryGDP;
    }

    public String getCapital(){
        return ctryCapital;   
    }

    public void setCountry(String country){
        ctryName = country;    
    }

    public void setContinent(String continent){
        ctryContinent = continent;   
    }

    public void setArea(int area){
        ctryArea = area;   
    }

    public void setPopulation(int population){
        ctryPopulation = population;   
    }

    public void setGDP(double gpa){
        ctryGDP = gpa;
    }

    public void setCapital(String capital){
        ctryCapital = capital;   
    }

    public String toString(){
        DecimalFormat gdp = new DecimalFormat("#.###");
        gdp.setGroupingUsed(true);
        gdp.setGroupingSize(3);
        String countryFormat = ctryName + ", Capital: " + ctryCapital + ", GDP: " + gdp.format(ctryGDP / 1000000000) + " billion, Per Capita GDP: " + gdp.format(ctryGDP / ctryPopulation);
        return countryFormat;
    }
    
    public int compareTo(Object other){
     Country c = (Country) other;
     return(int) (c.ctryGDP - ctryGDP);
    }
}
