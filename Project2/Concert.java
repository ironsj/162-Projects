import java.util.*; 
import java.text.*;
/**
 * Jake Irons
 * CIS 162 04
 * Project 2
 */
public class Concert
{
    private int concertDay;
    private int concertMonth;
    private int concertYear;
    private String artistName;
    private String concertVenue;
    private int numUpper;
    private int numLower;
    private int numFloor;
    private double totalSales;
    /** ticket prices for the different sections */
    private static final double PRICE_UPPER_TICKET = 29.90;
    private static final double PRICE_LOWER_TICKET = 99.0;
    private static final double PRICE_FLOOR_TICKET = 180.0;
    /** total number of tickets per section */
    private static final int TOTAL_NUMBER_UPPER_TICKETS= 300;
    private static final int TOTAL_NUMBER_LOWER_TICKETS= 300;
    private static final int TOTAL_NUMBER_FLOOR_TICKETS= 400;

    public Concert(){
        concertDay = 8;
        concertMonth = 9;
        concertYear = 2019;
        artistName = "Jonas Brothers";
        concertVenue = "Van Andel Arena";
        totalSales = 0;
        numUpper = TOTAL_NUMBER_UPPER_TICKETS;
        numLower = TOTAL_NUMBER_LOWER_TICKETS;
        numFloor = TOTAL_NUMBER_FLOOR_TICKETS;

    }

    public Concert(int m, int d, int y, String a, String v){
        Concert c = new Concert();
        if(c.isDateValid(m, d, y) == true){

            concertMonth = m;
            concertDay = d;
            concertYear = y;
        }
        else{
            System.out.println("Error - invalid date");   
        }
        artistName = a;
        concertVenue = v;
        totalSales = 0;
        numUpper = TOTAL_NUMBER_UPPER_TICKETS;
        numLower = TOTAL_NUMBER_LOWER_TICKETS;
        numFloor = TOTAL_NUMBER_FLOOR_TICKETS;

    }

    public String getArtist(){
        return artistName;
    }

    public String getVenue(){
        return concertVenue;
    }

    public double getTicketPrice (char ticketType){
        double ticketPrice = 0;
        if(ticketType == 'U'){ 
            ticketPrice = PRICE_UPPER_TICKET;
        }
        if(ticketType == 'L'){ 
            ticketPrice = PRICE_LOWER_TICKET;
        }
        if(ticketType == 'F'){ 
            ticketPrice = PRICE_FLOOR_TICKET;
        }
        return ticketPrice;
    }

    public int getAvailableUpperTickets(){
        return numUpper;
    }

    public int getAvailableLowerTickets(){
        return numLower; 
    }

    public int getAvailableFloorTickets(){
        return numFloor;  
    }

    public double getTotalSales (){
        return totalSales;
    }

    public int getMonth(){
        return concertMonth;
    }

    public int getDay(){
        return concertDay;
    }

    public int getYear(){
        return concertYear;
    }

    public void setArtist(String n){
        artistName = n;
    }

    public void setVenue(String n){
        concertVenue = n;   
    }

    public void setDate(int m, int d, int year){
        Concert c = new Concert();
        if(c.isDateValid(m, d, year) == true){

            concertMonth = m;
            concertDay = d;
            concertYear = year;
        }
        else{
            System.out.println("Error - invalid date");   
        }
    }

    private void parseDate(String date){
        int firstSlash = date.indexOf ("/");
        concertMonth = Integer.parseInt(date.substring(0, firstSlash));
        int secondSlash = date.lastIndexOf("/");
        concertDay = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        concertYear = Integer.parseInt(date.substring(secondSlash + 1, date.length()));
        Concert c = new Concert();
    }

    public Concert (String date, String a, String v){
        artistName = a;
        concertVenue = v;
        parseDate(date);
        Concert c = new Concert();
        if(c.isDateValid(concertMonth, concertDay, concertYear) == false){
            System.out.println("Error - invalid date");
            concertMonth = 0;
            concertDay = 0;
            concertYear = 0;
        }
        totalSales = 0;
        numUpper = TOTAL_NUMBER_UPPER_TICKETS;
        numLower = TOTAL_NUMBER_LOWER_TICKETS;
        numFloor = TOTAL_NUMBER_FLOOR_TICKETS;
    }

    public void buyTickets (char ticketType, int numTickets, double pmt){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        int numPurchasedTickets = numTickets;
        double amountPaid = pmt;
        if(ticketType == 'U'){
            if(numUpper - numPurchasedTickets >= 0){
                if(numPurchasedTickets > 0){
                    if(amountPaid >= (PRICE_UPPER_TICKET * numPurchasedTickets)){
                        totalSales += (PRICE_UPPER_TICKET * numPurchasedTickets);
                        numUpper -= numPurchasedTickets;
                        System.out.println("Transaction - Number tickets Upper Section: " 
                            + numPurchasedTickets + ", total: " 
                            + currency.format(PRICE_UPPER_TICKET * numPurchasedTickets));
                    }
                    else if(amountPaid >= 0 && amountPaid < 
                    (PRICE_UPPER_TICKET * numPurchasedTickets)){
                        System.out.println("Error - payment is not enough to buy the tickets");
                    }
                    else{
                        System.out.println("Error - invalid payment");   
                    }
                }
                else{
                    System.out.println("Error - invalid number of tickets");
                }
            }
            else{
                System.out.println("Tickets not available in upper section");   
            }
        }

        else if(ticketType == 'L'){
            if(numLower - numPurchasedTickets >= 0){
                if(numPurchasedTickets > 0){
                    if(amountPaid >= (PRICE_LOWER_TICKET * numPurchasedTickets)){
                        totalSales += (PRICE_LOWER_TICKET * numPurchasedTickets);
                        numLower -= numPurchasedTickets;
                        System.out.println("Transaction - Number tickets Lower Section: "
                            + numPurchasedTickets + ", total: " 
                            + currency.format(PRICE_LOWER_TICKET * numPurchasedTickets));
                    }
                    else if(amountPaid >= 0 && amountPaid < 
                    (PRICE_LOWER_TICKET * numPurchasedTickets)){
                        System.out.println("Error - payment is not enough to buy the tickets");
                    }
                    else{
                        System.out.println("Error - invalid payment");   
                    }
                }
                else{
                    System.out.println("Error - invalid number of tickets");
                }
            }
            else{
                System.out.println("Tickets not available in lower section");   
            }
        }

        else if(ticketType == 'F'){
            if(numFloor - numPurchasedTickets >= 0){
                if(numPurchasedTickets > 0){
                    if(amountPaid >= (PRICE_FLOOR_TICKET * numPurchasedTickets)){
                        totalSales += (PRICE_FLOOR_TICKET * numPurchasedTickets);
                        numFloor -= numPurchasedTickets;
                        System.out.println("Transaction - Number tickets Floor Section: " 
                            + numPurchasedTickets + ", total: " 
                            + currency.format(PRICE_FLOOR_TICKET * numPurchasedTickets));
                    }
                    else if(amountPaid >= 0 && amountPaid < 
                    (PRICE_FLOOR_TICKET * numPurchasedTickets)){
                        System.out.println("Error - payment is not enough to buy the tickets");
                    }
                    else{
                        System.out.println("Error - invalid payment");   
                    }
                }
                else{
                    System.out.println("Error - invalid number of tickets");
                }
            }
            else{
                System.out.println("Tickets not available in floor section");   
            }
        }

    }

    public void printReport(){
        Concert c = new Concert(concertMonth, concertDay, concertYear, artistName, concertVenue);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Concert Report");
        System.out.println("====================");
        System.out.println("Artist:         " + artistName);
        System.out.println("Venue:          " + concertVenue);
        System.out.print("Date:           ");
        System.out.println(c.formatDate(4));
        System.out.println("");
        System.out.println("Tickets sold:");
        System.out.println("=============");
        System.out.println("Upper: " + (TOTAL_NUMBER_UPPER_TICKETS - numUpper) + "        " 
               + currency.format((TOTAL_NUMBER_UPPER_TICKETS - numUpper) * PRICE_UPPER_TICKET));
        System.out.println("Lower: " + (TOTAL_NUMBER_LOWER_TICKETS - numLower) + "        " 
               + currency.format((TOTAL_NUMBER_LOWER_TICKETS - numLower) * PRICE_LOWER_TICKET));
        System.out.println("Floor: " + (TOTAL_NUMBER_FLOOR_TICKETS - numFloor) + "        " 
               + currency.format((TOTAL_NUMBER_FLOOR_TICKETS - numFloor) * PRICE_FLOOR_TICKET));
        System.out.println("==============");
        System.out.println("Total Sales:    " + currency.format(totalSales));

    }

    private boolean isLeapYear(int y){
        concertYear = y;
        if((concertYear % 400) == 0){
            return true;   
        }
        else if((concertYear % 100) == 0){
            return false;
        }
        else if((concertYear % 4) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isDateValid(int m, int d, int y){
        concertMonth = m;
        concertDay = d;
        concertYear = y;
        Concert c = new Concert();
        if(concertYear < 0){
            return false;
        }
        if(concertMonth > 12 || concertMonth < 1){
            return false;   
        }
        if(concertDay < 1 || concertDay > 31){
            return false;
        }

        if(concertMonth == 2){
            if((c.isLeapYear(concertYear) == true) && (concertDay <= 29)){
                return true;  
            }
            else if((c.isLeapYear(concertYear) == false) && (concertDay == 29)){
                return false; 
            }
            else{
                return true;   
            }
        }

        if((concertMonth == 4 || concertMonth == 6 || concertMonth == 9 
            || concertMonth == 11) && concertDay >= 31){
            return false;   
        }

        return true;

    }

    public String formatDate(int format){
        String dateFormat = "";
        DecimalFormat month = new DecimalFormat("00");
        DecimalFormat day = new DecimalFormat("00");
        String months = "JanFebMarAprMayJunJulAugSepOctNovDec";
        if(format == 1){
            dateFormat = concertMonth + "/" + concertDay + "/" + concertYear;
        }
        if(format == 2){
            dateFormat = month.format(concertMonth) + "/" 
            + day.format(concertDay) + "/" + concertYear;
        }
        if(format == 3){
            dateFormat = months.substring(((concertMonth*3)-3), (concertMonth * 3)) 
            + " " + concertDay + ", " + concertYear;
        }
        if(format == 4){
            String fullMonth = "January";
            switch(concertMonth){
                case 1:
                fullMonth = "January";
                break;

                case 2:
                fullMonth = "February";
                break;

                case 3:
                fullMonth = "March";
                break;

                case 4:
                fullMonth = "April";
                break;

                case 5:
                fullMonth = "May";
                break;

                case 6:
                fullMonth = "June";
                break;

                case 7:
                fullMonth = "July";
                break;

                case 8:
                fullMonth = "August";
                break;

                case 9:
                fullMonth = "September";
                break;

                case 10:
                fullMonth = "October";
                break;

                case 11:
                fullMonth = "November";
                break;

                case 12:
                fullMonth = "December";
                break;
            }
            dateFormat = fullMonth + " " + concertDay + ", " + concertYear;
        }
        return dateFormat;
    }

    public void simulateCompanyBuyingTickets(int numberTickets){
        Concert c = new Concert();
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        Random r = new Random();
        char ticketType = 'U';
        int numTickets = 1;
        double pmt = 0.00;
        int singleTicket = 1;
        while(numTickets <= numberTickets){
            int ticketNumber = r.nextInt(3) + 1;

            if(ticketNumber == 1){
                ticketType = 'U';
            }
            else if(ticketNumber == 2){
                ticketType = 'L';
            }
            else{
                ticketType = 'F';
            }

            if(ticketType == 'U'){
                pmt = PRICE_UPPER_TICKET;
            }
            else if(ticketType == 'L'){
                pmt = PRICE_LOWER_TICKET;
            }
            else{
                pmt = PRICE_FLOOR_TICKET;
            }

            c.buyTickets(ticketType, singleTicket, pmt);
            totalSales += pmt;
            if(ticketType == 'U'){
                numUpper -= 1;
            }
            else if(ticketType == 'L'){
                numLower -= 1;
            }
            else{
                numFloor -= 1;
            }
            if(numUpper <= 0){
                System.out.println("Upper Tickets not available");
            }
            else if(numLower <= 0){
                System.out.println("Lower Tickets not available");
            }
            else if(numFloor <= 0){
                System.out.println("Floor Tickets not available");
            }
            ++numTickets;
        }

    }
}

