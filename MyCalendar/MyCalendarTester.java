import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
enum MONTHS
{
	Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}
enum DAYS
{
	Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday ;
}

/**
 * CS151 HW2 MyCalendar: Main method
 * @author Sung Chi
 * version 1     
 */
public class MyCalendarTester {
	
	   
	   /** Helper of main method
	    * prints calendar
	    * @param n - int the date
	    * @param lastDayOfMonth - int last day of this month 
	    * @param today - todays date
	    */
	public static void datePrinter (int n, int lastDayOfMonth, int today){
		if(n== today){
			System.out.print("["+n+"]");
		}
		else if(n<=0){
			System.out.print("  ");
		}
		else if (n < 10){
			
			System.out.print(" "+n);
		}
		else if (n>lastDayOfMonth){
			System.out.print("  ");
		}
		else{
			System.out.print(n);
		}
	}
	   /** Helper of main method
	    *validates date by month, date, year
	    * @param date - String that contains mm/dd/yyyy
	    * @return boolean - true if date is valid form
	    */
	public static boolean dateValidator(String date){
		if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
		    return true;
		else
		   return false;
	}
	   /** Helper of main method
	    *validates time for event start time
	    * @param time - String that contains hh:mm
	    * @return boolean - true if time is valid form
	    */
	public static boolean timeValidator(String time){
		if (time.matches("([0-9]{2}):([0-9]{2})"))
		    return true;
		else
		   return false;
	}
	   /** Helper of main method
	    *validates time for event end time
	    * @param time - String that contains hh:mm
	    * @return boolean - true if time is valid form
	    */
	public static boolean timeValidator2(String time){
		if (time.matches("([0-9]{2}):([0-9]{2})"))
		    return true;
		else if (time.toUpperCase().equals("N"))
			return true;
		else
		   return false;
	}
	
	 /**
	    * @param args command line argument
	    * @throws IOException
	    */
	public static void main(String[] args) throws IOException {
		//print calendar to initial screen
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
		Calendar initCalendar= new GregorianCalendar();

		System.out.print("     "+arrayOfMonths[initCalendar.get(Calendar.MONTH)]+" ");
		int today = initCalendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(initCalendar.get(Calendar.YEAR));
		System.out.println("Su Mo Tu We Th Fr Sa");

		GregorianCalendar temp = new GregorianCalendar(initCalendar.get(Calendar.YEAR), initCalendar.get(Calendar.MONTH), 1);
		int[]arr = new int[42];
		
		int firstDayOfWeek=temp.get(Calendar.DAY_OF_WEEK)-1;
		int lastDayOfMonth= temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i=0; i<arr.length; i++){
			arr[i]= i+1+(firstDayOfWeek*-1);
		}
		for(int i=0; i<7; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=7; i<14; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=14; i<21; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=21; i<28; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=28; i<35; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=35; i<42; i++){
			datePrinter((arr[i]),lastDayOfMonth,today);
			System.out.print(" ");
		}
		
	
		//get user input
		Scanner scan = new Scanner(System.in);
		Connection connection = new Connection();
		boolean quit = false;
		
		while(quit == false){
			//display menu
			System.out.println("\n\n***Main Menu***");
			System.out.println("[L]oad");
			System.out.println("[V]iew by");
			System.out.println("[C]reate");
			System.out.println("[G]o to");
			System.out.println("[E]vent list");
			System.out.println("[D]elete");
			System.out.println("[Q]uit");
			
			String input = scan.next();
			
			switch(input.toUpperCase()){
				case "L":
					System.out.println("Loading previous event(s)...");
					connection.load();
					break;
				case "V": 
					boolean quit2 = false;
					//user input for Day View/ Month view
					while(quit2 == false){
						//print menu
						System.out.print("[D]ay view or [M]onth view ? ");						
						
						switch(scan.next().toUpperCase()){
							case "D":
								//display todays event
								connection.displayEventToday(scan);
								quit2 = true;
								break;
							case "M": 
								//display monthly calendar
								connection.displayCalendarByMonth(scan);													
								quit2 = true;
								break;
							default: 
								//wrong input
								System.out.println("Invalid Input: please enter valid input");
								break;
						}
					}
					break;
				case "C":
					//getting event information
					System.out.print("Title: ");
					scan.nextLine();
					String title = scan.nextLine();
					
					String date=" ";
					boolean validFormat= false;
					while(!validFormat){
					System.out.print("date (MM/DD/YYYY): ");	
					date = scan.nextLine();
					validFormat=dateValidator(date);
					if(dateValidator(date)==false)
						System.out.println("Wrong date format! try again");
					}
					
					String startingTime = " ";
					validFormat= false;
					while(!validFormat){
					System.out.print("Starting time (hh:mm): ");
					startingTime= scan.nextLine();
					validFormat=timeValidator(startingTime);
					if(timeValidator(startingTime)==false)
						System.out.println("Wrong date format! try again");
					}
					
					String endingTime = " ";
					validFormat= false;
					while(!validFormat){
					System.out.print("Ending time (hh:mm) [Press Enter [N] if not applicable]: ");
					endingTime= scan.nextLine();	
					validFormat=timeValidator2(endingTime);
					if(timeValidator2(endingTime)==false)
						System.out.println("Wrong date format! try again");
					}
					//store data as a event object
					Event newEvent = new Event(title, date, startingTime, endingTime);
					//create event
					connection.createEvent(newEvent);
					break;					
				case "G":
					//getting date
					String dateToDisplay=" ";
					validFormat= false;
					scan.nextLine();
					while(!validFormat){
					System.out.print("date (MM/DD/YYYY): ");	
					dateToDisplay = scan.nextLine();
					validFormat=dateValidator(dateToDisplay);
					if(dateValidator(dateToDisplay)==false)
					System.out.println("Wrong date format! try again");
					}
					//display events on that date
					connection.displayCalendarByDate(dateToDisplay);
					
					break;
				case "E":
					//display all the events
					connection.displayEventList();
					break;
				case "D":
					boolean quit3 = false;
					//user input for Selected/All
					while(quit3 == false){
						//print menu
						System.out.print("[S]elected or [A]ll ? ");						
						
						switch(scan.next().toUpperCase()){
							case "S":
								// userInput for date
								String dateToDelete=" ";
								validFormat= false;
								scan.nextLine();
								while(!validFormat){
								System.out.print("Enter the date (MM/DD/YYYY): ");	
								dateToDelete = scan.nextLine();
								validFormat=dateValidator(dateToDelete);
								if(dateValidator(dateToDelete)==false)
									System.out.println("Wrong date format! try again");
								}
								//delete events		
								connection.deleteEventByDate(dateToDelete);
								quit3 = true;
								break;
							case "A": 
								//all the events scheduled on this calendar will be deleted.
								connection.deleteAllEvent();
								quit3 = true;
								break;
							default: 
								//wrong input
								System.out.println("Invalid Input: please enter valid input");
								break;
						}
					}
					break;
				case "Q":
					//create output.text and exit program
					quit=true;
					connection.quit();
					System.out.println("Exiting program...");
					System.out.println("Thank you for Using My Calendar!");
					
					break;
				default: 
					System.out.println("Invalid Input: please enter valid input");
					break;
			}
		}
	}
}
