import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Class is responsible for displaying prompt,
 * and communicate with the Event Manager
 * @author Sung Chi
 */
public class Connection {
	private static EventManager eventManager;
	private String filename;
	  
	/**
	 * Full constructor
	*/
//constructor
	public Connection(){
		eventManager = new EventManager();
		
	}
//methods
	 /**
	  * load method
	  * connects to event manager to load Calendar file
	  * @throws IOException
	  */
	public void load() throws IOException{
		eventManager.loadCalendar();
	}
	 /**
      * get user inputs to determine which day to show
      * @param scan Scanner object used to get user input
	  */
	public void displayEventToday(Scanner scan){
		GregorianCalendar cal = new GregorianCalendar();
		printCalendarByDay(cal);
		boolean quit4 = false;
		while(quit4 == false){
			//print menu
			System.out.print("[P]revious or [N]ext or [M]ain menu ? ");						
			
			switch(scan.next().toUpperCase()){
				case "P":
					// display previous day
					cal.add(Calendar.DAY_OF_MONTH,-1);
					printCalendarByDay(cal);
					quit4 = false;
					break;
				case "N": 
					//display next day
					cal.add(Calendar.DAY_OF_MONTH,1);
					printCalendarByDay(cal);
					quit4 = false;
					break;
				case "M": 
					//back to main menu																
					quit4 = true;
					break;
				default: 
					//wrong input
					System.out.println("Invalid Input: please enter valid input");
					break;
			}
		}
	}
	 /**
     * print day view of the calendar
     * @param c Calendar which date to show
	  */
	public static void printCalendarByDay(Calendar c)
	{   MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    
	    System.out.print("\n"+arrayOfDays[c.get(Calendar.DAY_OF_WEEK)-1]);
	    System.out.print(", ");
		System.out.print(arrayOfMonths[c.get(Calendar.MONTH)]);
		System.out.print(" ");
		System.out.print(c.get(Calendar.DAY_OF_MONTH));
		System.out.print(", ");
		System.out.println(c.get(Calendar.YEAR));			
		
		int month = c.get(Calendar.MONTH)+1;
		int day_of_month = c.get(Calendar.DAY_OF_MONTH);
		int year = c.get(Calendar.YEAR);	
		
		String date = String.format("%02d",month)+"/"+String.format("%02d", day_of_month)+"/"+String.valueOf(year);
		//print event
		eventManager.eventPrinter(date);
	}
	
	 /**
     * get user inputs to determine which Month to show
     * @param scan Scanner object used to get user input
	  */
	public void displayCalendarByMonth(Scanner scan){
		GregorianCalendar cal = new GregorianCalendar();
		printCalendarByMonth(cal);
		//ask (prev, next , or go back)
		boolean quit5 = false;
		//user input for Prev/Next/Back
		while(quit5 == false){
			//print menu
			System.out.print("[P]revious or [N]ext or [M]ain menu ? ");						
			
			switch(scan.next().toUpperCase()){
				case "P":
					// display previous Month
					cal.add(Calendar.MONTH,-1);
					printCalendarByMonth(cal);
					quit5 = false;
					break;
				case "N": 
					//display next month
					cal.add(Calendar.MONTH,1);
					printCalendarByMonth(cal);
					quit5 = false;
					break;
				case "M": 
					//back to main menu																
					quit5 = true;
					break;
				default: 
					//wrong input
					System.out.println("Invalid Input: please enter valid input");
					break;
			}
			System.out.println();
		}
	}
	 /**
     * print day view of the calendar
     * @param initCalendar Calendar which date to show
	  */
	public void printCalendarByMonth(Calendar initCalendar){
		//print calendar to initial screen
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    System.out.println();
		System.out.print("     "+arrayOfMonths[initCalendar.get(Calendar.MONTH)]+" ");
		System.out.println(initCalendar.get(Calendar.YEAR));
		System.out.println("Su Mo Tu We Th Fr Sa");

		GregorianCalendar temp = new GregorianCalendar(initCalendar.get(Calendar.YEAR), (initCalendar.get(Calendar.MONTH)), 1);
		
		int[]arr = new int[42];
		
		int firstDayOfWeek=temp.get(Calendar.DAY_OF_WEEK)-1;
		int lastDayOfMonth= temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		int month = temp.get(Calendar.MONTH)+1;
		int year = temp.get(Calendar.YEAR);	
		
		for(int i=0; i<arr.length; i++){
			arr[i]= i+1+(firstDayOfWeek*-1);
		}
		for(int i=0; i<7; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=7; i<14; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=14; i<21; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=21; i<28; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=28; i<35; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=35; i<42; i++){
			datePrinter(year,month,(arr[i]),lastDayOfMonth);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
	   /**
	    * prints calendar
	    * @param year -int year
	    * @param month - int month
	    * @param n - int the date
	    * @param lastDayOfMonth - int last day of this month 
	    */
	public static void datePrinter (int year, int month, int n, int lastDayOfMonth){
		
		String date = String.format("%02d",month)+"/"+String.format("%02d", n)+"/"+String.valueOf(year);
		if(eventManager.eventExist(date)){
			System.out.print(n+"*");
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
	   /**
	    * Initiate create Event service
	    * @param event Event which event to create
	    */
	public void createEvent(Event event){
		eventManager.createEvent(event);
	}
	
	 /**
     * print specific day view of the calendar
     * @param date String which date to show
	  */
	public void displayCalendarByDate(String date){
		GregorianCalendar cal = new GregorianCalendar();
		int year=Integer.parseInt(dateSpliter(date).get(2));
		int dayOfMonth=Integer.parseInt(dateSpliter(date).get(1));
		int month=Integer.parseInt(dateSpliter(date).get(0))-1;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    
	    System.out.print("\n"+arrayOfDays[cal.get(Calendar.DAY_OF_WEEK)-1]);
	    System.out.print(", ");
		System.out.print(arrayOfMonths[cal.get(Calendar.MONTH)]);
		System.out.print(" ");
		System.out.print(cal.get(Calendar.DAY_OF_MONTH));
		System.out.print(", ");
		System.out.println(cal.get(Calendar.YEAR));		
		
		eventManager.eventPrinter(date);
	}
	   /** Helper method
	    * parses month, date, year from a line
	    * @param eventDate String date in mm/dd/yyyy format
	    * @return List - list contains month date and year
	    */
	public List<String> dateSpliter(String eventDate){
		List<String> dateArr = Arrays.asList(eventDate.split("/"));
		return dateArr; 
	}
	   /**
	    * Initiate event list service
	    */
	public void displayEventList(){		
		eventManager.eventList();
	}
	   /**
	    * Initiate delete event by date service
	    */
	public void deleteEventByDate(String date){
		eventManager.removeEvents(date);
	}
	   /**
	    * Initiate delete all events service
	    */
	public void deleteAllEvent(){
		eventManager.clearEvents();		
	}
	   /**
	    * Initiate quiting service
	    * @throws IOException
	    */
	public void quit() throws IOException{
		eventManager.updateFile();
		System.out.println("Saving Data...events.txt");

		
	}
}
