
/**
 * Jake Irons * CIS 162 04
 * Project 2 - Test
 */
public class ConcertTest
{
    public static void main(String[] args){
        System.out.println("Testing starts");
        int errors = 0;

        //instantiating a new concert
        Concert c1 = new Concert(7, 5, 1982, "Prince", "Madison Square Garden");

        /*buy 5 tickets in floor section, 25 tickets in lower section, 
        30 tickets in Upper Section*/
        c1.buyTickets('F', 5, 900.00);
        c1.buyTickets('L', 25, 2475.00);
        c1.buyTickets('U', 30, 897.00);
        if(c1.getTotalSales() != 4272.00){
            errors++;
            System.out.println("ERROR: Total sales should be 4272.00");
        }

        //buy ticket with error in input parameters
        c1.buyTickets('U', 1, 20.00);
        if(c1.getTotalSales() != 4272.00){
            errors++;
            System.out.println("ERROR: Total sales should be 4272.00");
        }

        //get ticket prices
        if(c1.getTicketPrice('U') != 29.90){
            errors++;
            System.out.println("ERROR: Upper ticket price should be 29.90");
        }
        if(c1.getTicketPrice('F') != 180.00){
            errors++;
            System.out.println("ERROR: Floor ticket price should be 180.00");
        }
        if(c1.getTicketPrice('L') != 99.00){
            errors++;
            System.out.println("ERROR: Lower ticket price should be 99.00");
        }

        //buy ticket with error in input parameters
        c1.buyTickets('U', 1, 20.00);
        if(c1.getTotalSales() != 4272.00){
            errors++;
            System.out.println("ERROR: Total sales should be 4272.00");
        }

        //attempt to change to leap day in non-leap year
        c1.setDate(2, 29, 2019);
        if((c1.getMonth() != 7) && (c1.getDay() !=5) && (c1.getYear() != 1982)){
            errors++;
            System.out.println("Error: Date should be September 5, 1982"); 
        }

        //get available tickets
        if(c1.getAvailableUpperTickets() != 270){
            errors++;
            System.out.println("ERROR: Available upper tickets should be 270");
        }
        if(c1.getAvailableLowerTickets() != 275){
            errors++;
            System.out.println("ERROR: Available lower tickets should be 275");
        }
        if(c1.getAvailableFloorTickets() != 395){
            errors++;
            System.out.println("ERROR: Available floor tickets should be 395");
        }

        //Simulate company buying 150 tickets
        c1.simulateCompanyBuyingTickets(150);

        //get concert report
        c1.printReport();

        //Finalize first set of tests
        System.out.println("Testing Complete. Number of errors: " + errors);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        /*
         * 
         * TEST 2
         * 
         */
        System.out.println("Testing starts");

        //inititating new concert
        Concert c2 = new Concert("6/18/1998", "Fiona Apple", "Palace of Auburn Hills");

        //attempt to buy negative tickets
        c2.buyTickets('F', -2, 260.00);
        if(c2.getTotalSales() != 0.00){
            errors++;
            System.out.println("ERROR: Total sales should be 4272.00");
        }

        //pay with negative money
        c2.buyTickets('F', 1, -180.00);
        if(c2.getTotalSales() != 0.00){
            errors++;
            System.out.println("ERROR: Total sales should be 4272.00");
        }

        //buy all tickets
        c2.buyTickets('F', 400, 72000.00);
        c2.buyTickets('U', 300, 8970.00);
        c2.buyTickets('L', 300, 29700.00);
        if(c2.getTotalSales() != 110670.00){
            errors++;
            System.out.println("ERROR: Total sales should be 110670.00");
        }

        //attempt to buy another of each ticket
        c2.buyTickets('F', 1, 180.00);
        c2.buyTickets('U', 1, 29.90);
        c2.buyTickets('L', 1, 99.00);
        if(c2.getTotalSales() != 110670.00){
            errors++;
            System.out.println("ERROR: Total sales should be 110670.00");
        }
        if(c2.getAvailableUpperTickets() != 0){
            errors++;
            System.out.println("ERROR: There should be 0 available Upper Tickets");
        }
        if(c2.getAvailableLowerTickets() != 0){
            errors++;
            System.out.println("ERROR: There should be 0 available Lower Tickets");
        }
        if(c2.getAvailableFloorTickets() != 0){
            errors++;
            System.out.println("ERROR: There should be 0 available Floor Tickets");
        }

        //attempt to change to invalid date
        c2.setDate(4, 31, 2016);
        if((c2.getMonth() != 6) && (c2.getDay() !=18) && (c2.getYear() != 1998)){
            errors++;
            System.out.println("Error: Date should be June 18, 1998"); 
        }

        //attempt to change to negative year
        c2.setDate(6, 18, -1998);
        if((c2.getMonth() != 6) && (c2.getDay() !=18) && (c2.getYear() != 1998)){
            errors++;
            System.out.println("Error: Date should be June 18, 1998"); 
        }

        //test set artist
        c2.setArtist("OutKast");
        if(c2.getArtist() != "OutKast"){
            errors++;
            System.out.println("Error: Artist should be OutKast");
        }

        //test set venue
        c2.setVenue("Georgia Dome");
        if(c2.getVenue() != "Georgia Dome"){
            errors++;
            System.out.println("Error: Venue should be Georgia Dome");
        }

        //test set date
        c2.setDate(10, 31, 2001);
        if((c2.getMonth() != 10) && (c2.getDay() !=31) && (c2.getYear() != 2001)){
            errors++;
            System.out.println("Error: Date should be October 31, 2001"); 
        }

        // print report
        c2.printReport();

        //Finalize second set of tests
        System.out.println("Testing Complete. Number of errors: " + errors);

        
    }
}
