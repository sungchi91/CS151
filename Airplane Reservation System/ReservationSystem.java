import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * CS151 HW1 Airline Reservation System: Main method
 * @author Sung Chi
 * version 1     
 */

public class ReservationSystem {
	 /**
    * @param args command line argument
    * @throws FileNotFoundException 
    * @throws Exception no file found
    */
	public static void main(String[] args) throws FileNotFoundException, Exception {
		 Connection connection = new Connection(args[0]);    
	   	Scanner scan = new Scanner(System.in);
       System.out.print("***Airline Reservation System***");
       boolean quit= false;
       do{
       quit = connection.initiateService(connection.displayMenu(scan),scan);
       }while(!quit);
	}

}
